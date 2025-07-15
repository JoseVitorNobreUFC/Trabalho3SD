package com.example.backend.repository.generics;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonObjectRepository<T> {
    private final File file;
    private final ObjectMapper objectMapper;
    private final Class<T> clazz;

    private Path rootDir = Paths.get("").toAbsolutePath();

    public JsonObjectRepository(String path, Class<T> clazz) {
        Path dataPath = rootDir.resolve("data").resolve(path);
        this.file = new File(dataPath.toString());
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.clazz = clazz;
    }

    public T load() {
        try {
            if (!file.exists()) {
                File parent = file.getParentFile();
                if (parent != null && !parent.exists()) {
                    parent.mkdirs();
                }
                T empty = clazz.getDeclaredConstructor().newInstance();
                save(empty);
                return empty;
            }
            return objectMapper.readValue(file, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception ex) {
                throw new RuntimeException("Erro ao instanciar objeto padrão", ex);
            }
        }
    }

    public void save(T data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.example.backend.repository.generics;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonObjectRepository<T> {
    private final File file;
    private final ObjectMapper objectMapper;
    private final Class<T> clazz;

    public JsonObjectRepository(String path, Class<T> clazz) {
        this.file = new File(path);
        this.objectMapper = new ObjectMapper();
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

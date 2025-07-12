package com.example.backend.repository.generics;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonRepository<T> {
    private final File file;
    private final ObjectMapper objectMapper;
    private final TypeReference<List<T>> typeReference;

    public JsonRepository(String path, TypeReference<List<T>> typeReference) {
        this.file = new File(path);
        this.objectMapper = new ObjectMapper();
        this.typeReference = typeReference;
    }

    public List<T> load() {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                objectMapper.writeValue(file, List.of());
            }
            return new java.util.ArrayList<>(objectMapper.readValue(file, typeReference));
        } catch (Exception e) {
            e.printStackTrace();
            return new java.util.ArrayList<>();
        }
    }

    public void save(List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

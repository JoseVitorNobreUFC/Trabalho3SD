package com.example.backend.repository.generics;

import com.example.backend.model.interfaces.Identificavel;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JsonRepository<T extends Identificavel> {
    // Identificavel é uma interface que garante que T tem getId() e setId()

    private final File file;
    private final ObjectMapper objectMapper;
    private final TypeReference<List<T>> typeReference;
    private List<T> cache;

    private Path rootDir = Paths.get("").toAbsolutePath();

    public JsonRepository(String path, TypeReference<List<T>> typeReference) {
        Path dataPath = rootDir.resolve("data").resolve(path);
        this.file = new File(dataPath.toString());
        this.objectMapper = new ObjectMapper();
        this.typeReference = typeReference;
        this.cache = load(); // mantemos cache para facilitar geração de ID
    }

    private int generateNextId() {
        return cache.stream().mapToInt(T::getId).max().orElse(0) + 1;
    }

    public T saveOne(T novo) {
        novo.setId(generateNextId());
        cache.add(novo);
        save(cache);
        return novo;
    }

    public List<T> findAll() {
        return new ArrayList<>(cache);
    }

    public Optional<T> findById(int id) {
        return cache.stream().filter(e -> e.getId() == id).findFirst();
    }

    public void deleteById(int id) {
        cache.removeIf(e -> e.getId() == id);
        save(cache);
    }

    public void update(T atualizado) {
        deleteById(atualizado.getId());
        cache.add(atualizado);
        save(cache);
    }

    public boolean existsByPredicate(Predicate<T> predicate) {
        return cache.stream().anyMatch(predicate);
    }

    private List<T> load() {
        try {
            if (!file.exists()) return new ArrayList<>();
            return objectMapper.readValue(file, typeReference);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void save(List<T> data) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


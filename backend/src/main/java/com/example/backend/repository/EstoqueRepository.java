package com.example.backend.repository;

import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.model.gerenciadores.Medicamentos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class EstoqueRepository {

    private final File file = new File("data/estoque.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<EnumAnimal, Medicamentos> load() {
        try {
            if (!file.exists()) return new HashMap<>();
            return objectMapper.readValue(file, new TypeReference<>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }

    public void save(Map<EnumAnimal, Medicamentos> estoque) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, estoque);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

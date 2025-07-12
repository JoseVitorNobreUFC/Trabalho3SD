package com.example.backend.repository;

import com.example.backend.model.animais.Animal;
import com.example.backend.repository.generics.JsonRepository;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class AnimalRepository extends JsonRepository<Animal> {
    public AnimalRepository() {
        super("data/animais.json", new TypeReference<List<Animal>>() {});
    }
}

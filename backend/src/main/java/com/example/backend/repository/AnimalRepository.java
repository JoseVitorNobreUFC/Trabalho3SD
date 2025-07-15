package com.example.backend.repository;

import com.example.backend.model.animais.AreaDeRepouso;
import com.example.backend.repository.generics.JsonObjectRepository;

public class AnimalRepository extends JsonObjectRepository<AreaDeRepouso> {
    public AnimalRepository() {
        super("animais.json", AreaDeRepouso.class);
    }
}

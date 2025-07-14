package com.example.backend.repository;

import com.example.backend.model.gerenciadores.Estoque;
import com.example.backend.repository.generics.JsonObjectRepository;

public class EstoqueRepository extends JsonObjectRepository<Estoque> {
    public EstoqueRepository() {
        super("estoque.json", Estoque.class);
    }
}

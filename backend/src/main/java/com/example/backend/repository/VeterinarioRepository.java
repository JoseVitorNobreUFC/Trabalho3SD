package com.example.backend.repository;

import com.example.backend.model.gerenciadores.Veterinario;
import com.example.backend.repository.generics.JsonRepository;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class VeterinarioRepository extends JsonRepository<Veterinario> {
    public VeterinarioRepository() {
        super("data/veterinarios.json", new TypeReference<List<Veterinario>>() {});
    }
}

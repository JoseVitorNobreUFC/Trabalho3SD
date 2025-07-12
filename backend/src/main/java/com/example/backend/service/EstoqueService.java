package com.example.backend.service;

import com.example.backend.model.gerenciadores.Medicamentos;
import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.repository.EstoqueRepository;

import java.util.HashMap;
import java.util.Map;

public class EstoqueService {

    private final EstoqueRepository repository;
    private final Map<EnumAnimal, Medicamentos> estoque;

    public EstoqueService() {
        this.repository = new EstoqueRepository();
        this.estoque = repository.load();
    }

    public Map<String, Integer> listarMedicamentos(EnumAnimal animal) {
        Medicamentos meds = estoque.get(animal);
        return meds != null ? meds.getItens() : new HashMap<>();
    }

    public void adicionarMedicamento(EnumAnimal animal, String nome, int quantidade) {
        estoque.computeIfAbsent(animal, a -> new Medicamentos()).adicionar(nome, quantidade);
        salvar();
    }

    public void aplicarMedicamento(EnumAnimal animal, String nome, int quantidade) {
        Medicamentos meds = estoque.get(animal);
        if (meds != null) {
            meds.remover(nome, quantidade);
            salvar();
        }
    }

    private void salvar() {
        repository.save(estoque);
    }
}

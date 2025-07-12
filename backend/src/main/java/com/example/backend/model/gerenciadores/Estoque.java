package com.example.backend.model.gerenciadores;

import java.util.HashMap;
import java.util.Map;

import com.example.backend.model.enums.EnumAnimal;

public class Estoque {

    private Map<EnumAnimal, Medicamentos> medicamentosPorAnimal;

    public Estoque() {
        this.medicamentosPorAnimal = new HashMap<>();
    }

    public void adicionarItem(EnumAnimal tipoAnimal, String nome, int quantidade) {
        medicamentosPorAnimal
            .computeIfAbsent(tipoAnimal, a -> new Medicamentos())
            .adicionar(nome, quantidade);
    }

    public void removerItem(EnumAnimal tipoAnimal, String nome, int quantidade) {
        Medicamentos medicamento = medicamentosPorAnimal.get(tipoAnimal);
        if (medicamento != null) {
            medicamento.remover(nome, quantidade);
        }
    }

    public Map<String, Integer> getMedicamentos(EnumAnimal tipoAnimal) {
        Medicamentos medicamento = medicamentosPorAnimal.get(tipoAnimal);
        return medicamento != null ? medicamento.getItens() : new HashMap<>();
    }

    public Map<EnumAnimal, Medicamentos> getTodos() {
        return medicamentosPorAnimal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        medicamentosPorAnimal.forEach((animal, medicamento) -> {
            sb.append("Animal: ").append(animal.name()).append("\n");
            sb.append(medicamento.toString());
        });
        return sb.toString();
    }
}
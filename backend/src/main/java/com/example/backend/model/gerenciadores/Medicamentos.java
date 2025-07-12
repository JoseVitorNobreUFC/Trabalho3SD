package com.example.backend.model.gerenciadores;

import java.util.HashMap;
import java.util.Map;

public class Medicamentos {
    private Map<String, Integer> itens;

    public Medicamentos() {
        this.itens = new HashMap<>();
    }

    public void adicionar(String nome, int quantidade) {
        itens.merge(nome, quantidade, Integer::sum);
    }

    public void remover(String nome, int quantidade) {
        if (itens.containsKey(nome)) {
            int atual = itens.get(nome);
            itens.put(nome, Math.max(0, atual - quantidade));
        }
    }

    public Map<String, Integer> getItens() {
        return itens;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        itens.forEach((k, v) -> sb.append("  ").append(k).append(": ").append(v).append("\n"));
        return sb.toString();
    }
}

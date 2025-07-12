package com.example.backend.repository;

import com.example.backend.model.gerenciadores.Agendamento;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class AgendamentoRepository extends JsonRepository<Agendamento> {
    public AgendamentoRepository() {
        super("data/agendamentos.json", new TypeReference<List<Agendamento>>() {});
    }
}

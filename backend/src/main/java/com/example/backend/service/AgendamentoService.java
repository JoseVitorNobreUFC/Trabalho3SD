package com.example.backend.service;

import com.example.backend.model.gerenciadores.Agendamento;
import com.example.backend.repository.AgendamentoRepository;

import java.util.List;

public class AgendamentoService {

    private final AgendamentoRepository repository;
    private final List<Agendamento> agendamentos;

    public AgendamentoService() {
        this.repository = new AgendamentoRepository();
        this.agendamentos = repository.load();
    }

    public List<Agendamento> listar() {
        return agendamentos;
    }

    public void agendar(Agendamento agendamento) {
        agendamentos.add(agendamento);
        salvar();
    }

    public void cancelar(int id) {
        if (id >= 0 && id < agendamentos.size()) {
            agendamentos.remove(id);
            salvar();
        } else {
            throw new IllegalArgumentException("Agendamento " + id + " não encontrado.");
        }
    }

    private void salvar() {
        repository.save(agendamentos);
    }

    public Agendamento buscar(int id) {
        if (id >= 0 && id < agendamentos.size()) {
            return agendamentos.get(id);
        } else {
            throw new IllegalArgumentException("Agendamento " + id + " não encontrado.");
        }
    }

    public void editar(int id, Agendamento novo) {
        if (id >= 0 && id < agendamentos.size()) {
            agendamentos.set(id, novo);
            salvar();
        } else {
            throw new IllegalArgumentException("Agendamento " + id + " não encontrado.");
        }
    }
}

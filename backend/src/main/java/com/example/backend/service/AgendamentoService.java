package com.example.backend.service;

import com.example.backend.exceptions.BadRequestException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.model.gerenciadores.Agendamento;
import com.example.backend.repository.AgendamentoRepository;

import java.util.List;

public class AgendamentoService {

    private final AgendamentoRepository repository;

    public AgendamentoService() {
        this.repository = new AgendamentoRepository();
    }

    public List<Agendamento> listar() {
        return repository.findAll();
    }

    public Agendamento buscar(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Agendamento " + id + " não encontrado."));
    }

    public Agendamento agendar(Agendamento novo) {
        boolean existe = repository.existsByPredicate(ag ->
                ag.getData().equals(novo.getData()) &&
                ag.getAnimal().getId() == novo.getAnimal().getId());

        if (existe) {
            throw new BadRequestException("Já existe um agendamento para esse animal nesta data.");
        }

        return repository.saveOne(novo);
    }

    public void cancelar(int id) {
        buscar(id);
        repository.deleteById(id);
    }

    public Agendamento editar(int id, Agendamento atualizado) {
        Agendamento original = buscar(id);
        boolean existe = repository.existsByPredicate(ag ->
                ag.getData().equals(atualizado.getData()) &&
                ag.getAnimal().getId() == atualizado.getAnimal().getId() &&
                ag.getVeterinario().getId() == atualizado.getVeterinario().getId());

        if (existe) {
            throw new BadRequestException("Já existe um agendamento para esse animal nesta data.");
        }
        atualizado.setId(original.getId());
        repository.update(atualizado);
        return atualizado;
    }
}

package com.example.backend.service;

import com.example.backend.exceptions.BadRequestException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.model.gerenciadores.Agendamento;
import com.example.backend.repository.AgendamentoRepository;

import java.util.List;

public class AgendamentoService {
    private static final AgendamentoService instance = new AgendamentoService();
    private final AgendamentoRepository repository;
    private final AnimalService animalService = AnimalService.getInstance();
    private final VeterinarioService veterinarioService = VeterinarioService.getInstance();

    public AgendamentoService() {
        this.repository = new AgendamentoRepository();
    }

    public static AgendamentoService getInstance() {
        return instance;
    }

    public List<Agendamento> listar() {
        return repository.load();
    }

    public boolean contemAnimal(int id) {
        List<Agendamento> agendamentos = listar();
        for (int i = 0; i < agendamentos.size(); i++) {
            if (agendamentos.get(i).getAnimal() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean contemVeterinario(int id) {
        List<Agendamento> agendamentos = listar();
        System.out.println(agendamentos);
        for (int i = 0; i < agendamentos.size(); i++) {
            if (agendamentos.get(i).getVeterinario() == id) {
                return true;
            }
        }
        return false;
    }

    public Agendamento buscar(int id) {
        List<Agendamento> agendamentos = listar();
        for (int i = 0; i < agendamentos.size(); i++) {
            if (agendamentos.get(i).getId() == id) {
                return agendamentos.get(i);
            }
        }
        throw new NotFoundException("Agendamento de id " + id + " nao encontrado");
    }

    public Agendamento agendar(Agendamento agendamento) {
        animalService.buscar(agendamento.getAnimal());
        veterinarioService.buscar(agendamento.getVeterinario());

        List<Agendamento> agendamentos = repository.findAll();
        boolean existe = agendamentos.stream().anyMatch(ag ->
                ag.getData().equals(agendamento.getData()) &&
                ag.getAnimal() == agendamento.getAnimal() &&
                ag.getVeterinario() == agendamento.getVeterinario());

        if (existe) {
            throw new BadRequestException("Já existe um agendamento para esse animal nesta data.");
        }

        return repository.saveOne(agendamento);
    }

    public void cancelar(int id) {
        buscar(id); 
        repository.deleteById(id);
    }

    public Agendamento editar(int id, Agendamento atualizado) {
        Agendamento original = buscar(id);

        animalService.buscar(atualizado.getAnimal());
        veterinarioService.buscar(atualizado.getVeterinario());

        List<Agendamento> agendamentos = repository.findAll();
        boolean existe = agendamentos.stream().anyMatch(ag ->
                ag.getData().equals(atualizado.getData()) &&
                ag.getAnimal() == atualizado.getAnimal() &&
                ag.getVeterinario() == atualizado.getVeterinario());

        if (existe) {
            throw new BadRequestException("Já existe um agendamento para esse animal nesta data.");
        }

        atualizado.setId(original.getId());
        repository.update(atualizado);
        return atualizado;
    }
}

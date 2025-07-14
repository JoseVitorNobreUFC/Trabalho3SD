package com.example.backend.service;

import com.example.backend.exceptions.BadRequestException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.model.animais.Animal;
import com.example.backend.repository.AnimalRepository;

import java.util.List;

public class AnimalService {
    private static final AnimalService instance = new AnimalService();
    private final AnimalRepository repository;
    private final AgendamentoService agendamentoService = AgendamentoService.getInstance();

    public AnimalService() {
        this.repository = new AnimalRepository();
    }

    public static AnimalService getInstance() {
        return instance;
    }

    public List<Animal> listar() {
        return repository.findAll();
    }

    public Animal buscar(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Animal " + id + " não encontrado."));
    }

    public Animal adicionar(Animal novo) {
        boolean existe = repository.existsByPredicate(animal ->
                animal.getNome().equals(novo.getNome()) &&
                animal.getIdade() == novo.getIdade() &&
                animal.getRaca().equals(novo.getRaca()));

        if (existe) {
            throw new BadRequestException("Já existe um animal com essas características.");
        }

        return repository.saveOne(novo);
    }

    public Animal editar(int id, Animal atualizado) {
        Animal original = buscar(id);
        boolean existe = repository.existsByPredicate(animal ->
                animal.getNome().equals(atualizado.getNome()) &&
                animal.getIdade() == atualizado.getIdade() &&
                animal.getRaca().equals(atualizado.getRaca()));

        if (existe) {
            throw new BadRequestException("Já existe um animal com essas características.");
        }
        atualizado.setId(original.getId());
        repository.update(atualizado);
        return atualizado;
    }

    public void remover(int id) {
        if(agendamentoService.contemAnimal(id)) {
            throw new BadRequestException("Animal possui agendamento");
        }
        buscar(id);
        repository.deleteById(id);
    }
}

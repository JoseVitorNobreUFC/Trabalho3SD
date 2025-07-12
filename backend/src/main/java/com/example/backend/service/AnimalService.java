package com.example.backend.service;

import com.example.backend.exceptions.NotFoundException;
import com.example.backend.model.animais.Animal;
import com.example.backend.repository.AnimalRepository;

import java.util.List;

public class AnimalService {

    private final AnimalRepository repository;
    private final List<Animal> animais;

    public AnimalService() {
        this.repository = new AnimalRepository();
        this.animais = repository.load();
    }

    public List<Animal> listar() {
        return animais;
    }

    public void adicionar(Animal animal) {
        animais.add(animal);
        salvar();
    }

    public void remover(int id) {
        if (id >= 0 && id < animais.size()) {
            animais.remove(id);
            salvar();
        } else {
            throw new NotFoundException("Animal " + id + " não encontrado.");
        }
    }

    private void salvar() {
        repository.save(animais);
    }

    public Animal buscar(int id) {
        if (id >= 0 && id < animais.size()) {
            return animais.get(id);
        } else {
            throw new NotFoundException("Animal " + id + " não encontrado.");
        }
    }

    public void editar(int id, Animal novo) {
        if (id >= 0 && id < animais.size()) {
            animais.set(id, novo);
            salvar();
        } else {
            throw new NotFoundException("Animal " + id + " não encontrado.");
        }
    }
}

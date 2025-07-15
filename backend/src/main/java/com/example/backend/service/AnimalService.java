package com.example.backend.service;

import com.example.backend.exceptions.BadRequestException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.model.animais.Animal;
import com.example.backend.model.animais.AreaDeRepouso;
import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.repository.AnimalRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalService {
    private static final AnimalService instance = new AnimalService();
    private final AnimalRepository repository;
    private final AgendamentoService agendamentoService = AgendamentoService.getInstance();
    private AreaDeRepouso areaDeRepouso;

    public AnimalService() {
        this.repository = new AnimalRepository();
        this.areaDeRepouso = repository.load();
    }

    public static AnimalService getInstance() {
        return instance;
    }

    public Map<EnumAnimal, List<Animal>> listar() {
        AreaDeRepouso animais = new AreaDeRepouso(areaDeRepouso.getAnimais());
        return animais != null ? animais.getAnimais() : new HashMap<>();
    }

    public void adicionar(EnumAnimal tipo, Animal animal) {
        if (areaDeRepouso.exists(tipo, animal)) {
            throw new BadRequestException("Animal já cadastrado");
        }

        int proximoId = areaDeRepouso.getAnimais().values().stream()
                .flatMap(List::stream)
                .mapToInt(Animal::getId)
                .max()
                .orElse(0) + 1;

        animal.setId(proximoId);
        areaDeRepouso.addAnimal(tipo, animal);
        salvar();
    }

    public void removeAnimal(int idAnimal) {
        if (agendamentoService.contemAnimal(idAnimal)) {
            throw new BadRequestException("Animal possui agendamento");
        }
        areaDeRepouso.removeAnimal(idAnimal);
        salvar();
    }

    public void editarAnimal(EnumAnimal tipo, int idAnimal, Animal animal) {
        if (areaDeRepouso.exists(tipo, animal)) {
            throw new BadRequestException("Animal já existe");
        }
        areaDeRepouso.editarAnimal(tipo, idAnimal, animal);
        salvar();
    }

    public List<Animal> listarPorTipo(EnumAnimal tipo) {
        return areaDeRepouso.getAnimais(tipo);
    }

    public Map<EnumAnimal, List<Animal>> buscarEmTodos(String nome) {
        AreaDeRepouso animais = new AreaDeRepouso(areaDeRepouso.buscarEmTodos(nome));
        return animais != null ? animais.getAnimais() : new HashMap<>();
    }

    public Animal buscar(int id) {
        if (areaDeRepouso.getById(id) != null) {
            return areaDeRepouso.getById(id);
        }
        throw new NotFoundException("Animal " + id + " nao encontrado.");
    }

    private void salvar() {
        repository.save(areaDeRepouso);
    }
}

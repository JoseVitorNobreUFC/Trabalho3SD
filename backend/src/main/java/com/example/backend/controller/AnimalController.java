package com.example.backend.controller;

import com.example.backend.model.animais.Animal;
import com.example.backend.service.AnimalService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController() {
        this.animalService = new AnimalService();
    }

    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    public List<Animal> listarAnimais() {
        return animalService.listar();
    }

    @PostMapping("path")
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }

    public void adicionarAnimal(@RequestBody Animal animal) {
        animalService.adicionar(animal);
    }

    @DeleteMapping("/{id}")
    public void removerAnimal(@PathVariable int id) {
        animalService.remover(id);
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id) {
        return animalService.buscar(id);
    }

    @PutMapping("/{id}")
    public void editarAnimal(@PathVariable int id, @RequestBody Animal novo) {
        animalService.editar(id, novo);
    }

}

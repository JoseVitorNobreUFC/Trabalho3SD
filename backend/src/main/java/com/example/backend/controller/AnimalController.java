package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.animais.Animal;
import com.example.backend.service.AnimalService;

@RestController
@RequestMapping("/animais")
@CrossOrigin(origins = "http://127.0.0.1:5500") 
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

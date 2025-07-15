package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.animais.Animal;
import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.service.AnimalService;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController() {
        this.animalService = new AnimalService();
    }

    @GetMapping()
    public Map<EnumAnimal, List<Animal>> listarAnimais() {
        return animalService.listar();
    }

    @PostMapping("/{tipo}")
    public void adicionarAnimal(@PathVariable EnumAnimal tipo, @RequestBody Animal animal) {
        animalService.adicionar(tipo, animal);
    }

    @DeleteMapping("/{id}")
    public void removerAnimal(@PathVariable int id) {
        animalService.removeAnimal(id);
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable int id) {
        return animalService.buscar(id);
    }

    @PutMapping("/{id}")
    public void editarAnimal(@PathVariable int id, @RequestBody EnumAnimal tipo, @RequestBody Animal novo) {
        animalService.editarAnimal(tipo, id, novo);
    }

}

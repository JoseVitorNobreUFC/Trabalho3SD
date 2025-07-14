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
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.gerenciadores.Veterinario;
import com.example.backend.service.VeterinarioService;

@RestController
@RequestMapping("/veterinarios")
@CrossOrigin(origins = "http://127.0.0.1:5500") 

public class VeterinarioController {

    private final VeterinarioService veterinarioService;

    public VeterinarioController() {
        this.veterinarioService = new VeterinarioService();
    }

    @GetMapping
    public List<Veterinario> listarVeterinarios() {
        return veterinarioService.listar();
    }

    @PostMapping
    public void adicionarVeterinario(@RequestBody Veterinario veterinario) {
        veterinarioService.adicionar(veterinario);
    }

    @DeleteMapping("/{id}")
    public void removerVeterinario(@PathVariable int id) {
        veterinarioService.remover(id);
    }

    @GetMapping("/{id}")
    public Veterinario getVeterinario(@PathVariable int id) {
        return veterinarioService.buscar(id);
    }

    @PutMapping("/{id}")
    public void editarVeterinario(@PathVariable int id, @RequestBody Veterinario novo) {
        veterinarioService.editar(id, novo);
    }
}

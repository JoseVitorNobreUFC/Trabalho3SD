package com.example.backend.controller;

import com.example.backend.model.gerenciadores.Veterinario;
import com.example.backend.service.VeterinarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios")
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

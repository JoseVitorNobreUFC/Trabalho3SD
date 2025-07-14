package com.example.backend.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.service.EstoqueService;

@RestController
@RequestMapping("/estoque")
@CrossOrigin(origins = "http://127.0.0.1:5500") 
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController() {
        this.estoqueService = new EstoqueService();
    }

    @GetMapping("/{animal}")
    public Map<String, Integer> listarMedicamentos(@PathVariable EnumAnimal animal) {
        return estoqueService.listarMedicamentos(animal);
    }

    @PostMapping("/{animal}/adicionar")
    public void adicionarMedicamento(
            @PathVariable EnumAnimal animal,
            @RequestParam String nome,
            @RequestParam int quantidade) {
        estoqueService.adicionarMedicamento(animal, nome, quantidade);
    }

    @PostMapping("/{animal}/aplicar")
    public void aplicarMedicamento(
            @PathVariable EnumAnimal animal,
            @RequestParam String nome,
            @RequestParam int quantidade) {
        estoqueService.aplicarMedicamento(animal, nome, quantidade);
    }

    @GetMapping("/buscar")
    public Map<EnumAnimal, Integer> buscarMedicamentoGlobal(@RequestParam String nome) {
        return estoqueService.buscarEmTodos(nome);
    }

    @PutMapping("/{animal}/editar-nome")
    public void editarNomeMedicamento(
            @PathVariable EnumAnimal animal,
            @RequestParam String antigo,
            @RequestParam String novo) {
        estoqueService.editarNomeMedicamento(animal, antigo, novo);
    }

    @GetMapping("/todos")
    public Map<EnumAnimal, Map<String, Integer>> listarTodos() {
        return estoqueService.listarTodos();
    }

}

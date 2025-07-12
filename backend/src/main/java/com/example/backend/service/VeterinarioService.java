package com.example.backend.service;

import com.example.backend.model.gerenciadores.Veterinario;
import com.example.backend.repository.VeterinarioRepository;

import java.util.List;

public class VeterinarioService {

    private final VeterinarioRepository repository;
    private final List<Veterinario> veterinarios;

    public VeterinarioService() {
        this.repository = new VeterinarioRepository();
        this.veterinarios = repository.load();
    }

    public List<Veterinario> listar() {
        return veterinarios;
    }

    public void adicionar(Veterinario veterinario) {
        veterinarios.add(veterinario);
        salvar();
    }

    public void remover(int id) {
        if (id >= 0 && id < veterinarios.size()) {
            veterinarios.remove(id);
            salvar();
        } else {
            throw new IllegalArgumentException("Veterinário " + id + " não encontrado.");
        }
    }

    private void salvar() {
        repository.save(veterinarios);
    }

    public Veterinario buscar(int id) {
        if (id >= 0 && id < veterinarios.size()) {
            return veterinarios.get(id);
        } else {
            throw new IllegalArgumentException("Veterinário " + id + " não encontrado.");
        }
    }

    public void editar(int id, Veterinario novo) {
        if (id >= 0 && id < veterinarios.size()) {
            veterinarios.set(id, novo);
            salvar();
        } else {
            throw new IllegalArgumentException("Veterinário " + id + " não encontrado.");
        }
    }
}

package com.example.backend.service;

import com.example.backend.exceptions.BadRequestException;
import com.example.backend.exceptions.NotFoundException;
import com.example.backend.model.gerenciadores.Veterinario;
import com.example.backend.repository.VeterinarioRepository;

import java.util.List;

public class VeterinarioService {
    private static final VeterinarioService instance = new VeterinarioService();
    private final VeterinarioRepository repository;
    private final AgendamentoService agendamentoService = AgendamentoService.getInstance();

    public VeterinarioService() {
        this.repository = new VeterinarioRepository();
    }

    public static VeterinarioService getInstance() {
        return instance;
    }

    public List<Veterinario> listar() {
        return repository.load();
    }

    public Veterinario adicionar(Veterinario veterinario) {
        boolean existe = this.listar().stream().anyMatch(vet ->
                vet.getNome().equals(veterinario.getNome()) &&
                vet.getEspecialidade().equals(veterinario.getEspecialidade()));

        if (existe) {
            throw new BadRequestException("Já existe um veterinário com essas características.");
        }

        return repository.saveOne(veterinario);
    }

    public void remover(int id) {
        System.out.println(agendamentoService.contemVeterinario(id));
        if (agendamentoService.contemVeterinario(id)) {
            throw new BadRequestException("Veterinário possui agendamento");
        }

        buscar(id);
        repository.deleteById(id);
    }

    public Veterinario buscar(int id) {
        List<Veterinario> veterinarios = listar();

        return veterinarios.stream()
                .filter(vet -> vet.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Veterinário de id " + id + " nao encontrado"));
    }

    public Veterinario editar(int id, Veterinario novo) {
        Veterinario original = buscar(id);

        List<Veterinario> veterinarios = repository.findAll();
        boolean existe = veterinarios.stream().anyMatch(vet ->
                vet.getNome().equals(novo.getNome()) &&
                vet.getEspecialidade().equals(novo.getEspecialidade()));

        if (existe) {
            throw new BadRequestException("Já existe um veterinário com essas características.");
        }

        novo.setId(original.getId());
        repository.update(novo);
        return novo;
    }
}

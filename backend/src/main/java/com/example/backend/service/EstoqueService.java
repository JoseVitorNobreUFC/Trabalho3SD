package com.example.backend.service;

import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.model.gerenciadores.Estoque;
import com.example.backend.model.gerenciadores.Medicamentos;
import com.example.backend.repository.EstoqueRepository;

import java.util.HashMap;
import java.util.Map;

public class EstoqueService {

    private final EstoqueRepository repository;
    private final Estoque estoque;

    public EstoqueService() {
        this.repository = new EstoqueRepository();
        this.estoque = repository.load();
    }

    public Map<String, Integer> listarMedicamentos(EnumAnimal animal) {
        Medicamentos meds = new Medicamentos(estoque.getMedicamentos(animal));
        return meds != null ? meds.getItens() : new HashMap<>();
    }

    public void adicionarMedicamento(EnumAnimal animal, String nome, int quantidade) {
        estoque.adicionarItem(animal, nome, quantidade);
        salvar();
    }

    public void aplicarMedicamento(EnumAnimal animal, String nome, int quantidade) {
        Medicamentos meds = new Medicamentos(estoque.getMedicamentos(animal));
        if (meds != null) {
            meds.remover(nome, quantidade);
            salvar();
        }
    }

    public void editarNomeMedicamento(EnumAnimal animal, String antigoNome, String novoNome) {
        Medicamentos meds = new Medicamentos(estoque.getMedicamentos(animal));
        if (meds != null && meds.getItens().containsKey(antigoNome)) {
            int quantidade = meds.getItens().remove(antigoNome);
            meds.getItens().put(novoNome, quantidade);
            salvar();
        }
    }

    public Map<EnumAnimal, Integer> buscarEmTodos(String nome) {
        Map<EnumAnimal, Integer> resultado = new HashMap<>();
        for (EnumAnimal animal : EnumAnimal.values()) {
            Medicamentos meds = new Medicamentos(estoque.getMedicamentos(animal));
            if (meds != null) {
                Integer qtd = meds.getItens().get(nome);
                if (qtd != null) {
                    resultado.put(animal, qtd);
                }
            }
        }
        return resultado;
    }

    public Map<EnumAnimal, Map<String, Integer>> listarTodos() {
        Map<EnumAnimal, Map<String, Integer>> copia = new HashMap<>();
        for (EnumAnimal animal : EnumAnimal.values()) {
            Medicamentos meds = new Medicamentos(estoque.getMedicamentos(animal));
            if (meds != null) {
                copia.put(animal, new HashMap<>(meds.getItens()));
            }
        }
        return copia;
    }

    private void salvar() {
        repository.save(estoque);
    }
}

package com.example.backend.model.gerenciadores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.backend.model.animais.Animal;
import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.model.interfaces.Consulta;

public abstract class ConsultaBase implements Consulta {
    protected Estoque estoque;
    protected ArrayList<Agendamento> agendamentos;
    protected ArrayList<Animal> animais;

    public ConsultaBase() {
        this.estoque = new Estoque();
        this.agendamentos = new ArrayList<>();
        this.animais = new ArrayList<>();
    }

    @Override
    public void cancelarConsulta(int id) {
        if (id >= 0 && id < agendamentos.size()) {
            agendamentos.remove(id);
        } else {
            throw new IllegalArgumentException("Consulta " + id + " não encontrada.");
        }
    }

    @Override
    public Map<String, Integer> getMedicamentos(EnumAnimal animal) {
        return estoque.getMedicamentos(animal);
    }

    @Override
    public void realizarConsulta(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    @Override
    public void aplicarMedicamento(EnumAnimal animal, String medicamento, int quantidade) {
        estoque.removerItem(animal, medicamento, quantidade);
    }

    @Override
    public void adicionarMedicamento(EnumAnimal animal, String medicamento, int quantidade) {
        estoque.adicionarItem(animal, medicamento, quantidade);
    }

    @Override
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
    }

    @Override
    public ArrayList<Animal> getAnimais() {
        return animais;
    }

    @Override
    public void removerAnimal(int id) {
        if (id >= 0 && id < animais.size()) {
            animais.remove(id);
        } else {
            throw new IllegalArgumentException("Animal " + id + " não encontrado.");
        }
    }

    @Override
    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }
}

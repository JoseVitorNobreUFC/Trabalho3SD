package com.example.backend.model.animais;

import com.example.backend.model.interfaces.Identificavel;

public abstract class Animal implements Identificavel {
    protected int id;
    protected String nome;
    protected int idade;
    protected String raca;

    public Animal(int id, String nome, int idade, String raca) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
    }

    public Animal() {}

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getRaca() {
        return this.raca;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            " nome='" + getNome() + "'" +
            ", idade='" + getIdade() + "'" +
            ", raca='" + getRaca() + "'" +
            "}";
    }
}
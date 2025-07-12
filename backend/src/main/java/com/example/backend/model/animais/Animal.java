package com.example.backend.model.animais;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "tipo")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Gato.class, name = "GATO"),
    @JsonSubTypes.Type(value = Cachorro.class, name = "CACHORRO"),
    @JsonSubTypes.Type(value = Papagaio.class, name = "PAPAGAIO")
})
public abstract class Animal {
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

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public String getRaca() {
        return this.raca;
    }

    public int getId() {
        return this.id;
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
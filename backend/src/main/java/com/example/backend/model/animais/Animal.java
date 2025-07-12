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
    protected String nome;
    protected int idade;
    protected String raca;

    public Animal(String nome, int idade, String raca) {
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

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", idade='" + getIdade() + "'" +
            ", raca='" + getRaca() + "'" +
            "}";
    }
}
package com.example.backend.model.gerenciadores;

public class Veterinario {
  private int id;
  private String nome;
  private String especialidade;

  public Veterinario(int id, String nome, String especialidade) {
    this.id = id;
    this.nome = nome;
    this.especialidade = especialidade;
  }

  public String getNome() {
    return nome;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Veterinario{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", especialidade='" + especialidade + '\'' +
        '}';
  }

}

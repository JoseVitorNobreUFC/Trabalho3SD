package com.example.backend.model.gerenciadores;

public class Veterinario {
  private String nome;
  private String especialidade;

  public Veterinario(String nome, String especialidade) {
    this.nome = nome;
    this.especialidade = especialidade;
  }

  public String getNome() {
    return nome;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  @Override
  public String toString() {
    return "Veterinario [nome=" + nome + ", especialidade=" + especialidade + "]";
  }

}

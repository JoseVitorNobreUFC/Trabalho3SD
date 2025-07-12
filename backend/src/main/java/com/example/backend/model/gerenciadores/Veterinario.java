package com.example.backend.model.gerenciadores;

import com.example.backend.model.interfaces.Identificavel;

public class Veterinario implements Identificavel {
  private int id;
  private String nome;
  private String especialidade;

  public Veterinario(int id, String nome, String especialidade) {
    this.id = id;
    this.nome = nome;
    this.especialidade = especialidade;
  }

  public Veterinario() {}

  public String getNome() {
    return nome;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
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

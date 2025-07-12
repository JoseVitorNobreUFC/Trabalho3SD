package com.example.backend.model.gerenciadores;

import java.sql.Date;

import com.example.backend.model.animais.Animal;

public class Agendamento {
  private Date data;
  private Animal animal;
  private Veterinario veterinario;

  public Agendamento(Date data, Animal animal, Veterinario veterinario) {
    this.data = data;
    this.animal = animal;
    this.veterinario = veterinario;
  }

  public Date getData() {
    return data;
  }

  public Animal getAnimal() {
    return animal;
  }

  public Veterinario getVeterinario() {
    return veterinario;
  }
}
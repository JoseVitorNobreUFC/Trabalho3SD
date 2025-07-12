package com.example.backend.model.gerenciadores;

import java.sql.Date;

import com.example.backend.model.animais.Animal;

public class Agendamento {
  private int id;
  private Date data;
  private Animal animal;
  private Veterinario veterinario;

  public Agendamento(int id, Date data, Animal animal, Veterinario veterinario) {
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

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Agendamento{" +
        "id=" + id +
        ", data=" + data +
        ", animal=" + animal +
        ", veterinario=" + veterinario +
        '}';
  }
}
package com.example.backend.model.gerenciadores;

import java.sql.Date;

import com.example.backend.model.animais.Animal;
import com.example.backend.model.interfaces.Identificavel;

public class Agendamento implements Identificavel{
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

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
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
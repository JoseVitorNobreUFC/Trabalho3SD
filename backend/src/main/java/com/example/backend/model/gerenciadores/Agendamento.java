package com.example.backend.model.gerenciadores;

import java.time.LocalDate;

import com.example.backend.model.interfaces.Identificavel;

public class Agendamento implements Identificavel{
  private int id;
  private LocalDate data;
  private int idAnimal;
  private int idVeterinario;

  public Agendamento(int id, LocalDate data, int idAnimal, int idVeterinario) {
    this.data = data;
    this.idAnimal = idAnimal;
    this.idVeterinario = idVeterinario;
    this.id = id;
  }

  public Agendamento() {}

  public LocalDate getData() {
    return data;
  }

  public int getAnimal() {
    return idAnimal;
  }

  public int getVeterinario() {
    return idVeterinario;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  public void setData(LocalDate data) {
    this.data = data;
  }

  public void setAnimal(int idAnimal) {
    this.idAnimal = idAnimal;
  }

  public void setVeterinario(int idVeterinario) {
    this.idVeterinario = idVeterinario;
  }

  @Override
  public String toString() {
    return "Agendamento{" +
        "id=" + id +
        ", data=" + data +
        ", idAnimal=" + idAnimal +
        ", idVeterinario=" + idVeterinario +
        '}';
  }
}
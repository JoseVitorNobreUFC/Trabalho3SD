package com.example.backend.model.gerenciadores;

import java.sql.Date;

import com.example.backend.model.interfaces.Identificavel;

public class Agendamento implements Identificavel{
  private int id;
  private Date data;
  private int idAnimal;
  private int idVeterinario;

  public Agendamento(int id, Date data, int idAnimal, int idVeterinario) {
    this.data = data;
    this.idAnimal = idAnimal;
    this.idVeterinario = idVeterinario;
    this.id = id;
  }

  public Agendamento() {}

  public Date getData() {
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

  public void setData(Date data) {
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
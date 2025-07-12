package com.example.backend.model.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.backend.model.animais.Animal;
import com.example.backend.model.enums.EnumAnimal;
import com.example.backend.model.gerenciadores.Agendamento;

public interface Consulta {
  public void realizarConsulta(Agendamento agendamento);
  public void cancelarConsulta(int id);
  public Map<String, Integer> getMedicamentos(EnumAnimal animal);
  public void aplicarMedicamento(EnumAnimal animal, String medicamento, int quantidade);
  public void adicionarMedicamento(EnumAnimal animal, String medicamento, int quantidade);
  public void adicionarAnimal(Animal animal);
  public ArrayList<Animal> getAnimais();
  public void removerAnimal(int id);
  public List<Agendamento> getAgendamentos();
}

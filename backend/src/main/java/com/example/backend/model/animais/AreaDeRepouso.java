package com.example.backend.model.animais;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.backend.model.enums.EnumAnimal;

public class AreaDeRepouso {
  private Map<EnumAnimal, List<Animal>> animais;

  public AreaDeRepouso() {
    this.animais = new HashMap<>();
  }

  public AreaDeRepouso(Map<EnumAnimal, List<Animal>> animais) {
    this.animais = animais;
  }

  public Map<EnumAnimal, List<Animal>> getAnimais() {
    return animais;
  }

  public void addAnimal(EnumAnimal tipo, Animal animal) {
    animais.get(tipo).add(animal);
  }

  public void removeAnimal(int idAnimal) {
    animais.values().forEach(list -> list.removeIf(animal -> animal.getId() == idAnimal));
  }

  public void editarAnimal(EnumAnimal tipo, int idAnimal, Animal animal) {
    animais.get(tipo).removeIf(animal1 -> animal1.getId() == idAnimal);
    animais.get(tipo).add(animal);
  }

  public List<Animal> getAnimais(EnumAnimal tipo) {
    return animais.get(tipo);
  }

  public Map<EnumAnimal, List<Animal>> buscarEmTodos(String nome) {
    Map<EnumAnimal, List<Animal>> resultado = new HashMap<>();
    for (EnumAnimal animal : EnumAnimal.values()) {
      List<Animal> animaisDoAnimal = animais.get(animal);
      if (animaisDoAnimal != null) {
        List<Animal> animaisEncontrados = animaisDoAnimal.stream().filter(animal1 -> animal1.getNome().contains(nome)).toList();
        if (!animaisEncontrados.isEmpty()) {
          resultado.put(animal, animaisEncontrados);
        }
      }
    }
    return resultado;
  }

  public Animal getById(int id) {
    for (EnumAnimal animal : EnumAnimal.values()) {
      List<Animal> animaisDoAnimal = animais.get(animal);
      if (animaisDoAnimal != null) {
        Animal animalEncontrado = animaisDoAnimal.stream().filter(animal1 -> animal1.getId() == id).findFirst().orElse(null);
        if (animalEncontrado != null) {
          return animalEncontrado;
        }
      }
    }
    return null;
  }

  public boolean exists(Animal animal) {
    for (EnumAnimal tipo : EnumAnimal.values()) {
      List<Animal> animaisDoAnimal = animais.get(tipo);
      if (animaisDoAnimal != null) {
        for (Animal animalDoAnimal : animaisDoAnimal) {
          if (animalDoAnimal.equals(animal)) {
            return true;
          }
        }
      }
    }
    return false;
  }
}

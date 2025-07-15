package com.example.backend.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EnumAnimal {
    GATO, CACHORRO, PAPAGAIO;

    @JsonCreator
    public static EnumAnimal from(String value) {
        try {
            return EnumAnimal.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Tipo de animal inválido: " + value);
        }
    }
}

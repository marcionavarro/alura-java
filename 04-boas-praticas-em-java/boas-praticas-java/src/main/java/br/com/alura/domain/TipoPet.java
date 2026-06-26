package br.com.alura.domain;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoPet {
    CACHORRO,
    GATO;

    @JsonCreator
    public static TipoPet

    fromString(String value) {
        return TipoPet.valueOf(value.trim().toUpperCase());
    }
}

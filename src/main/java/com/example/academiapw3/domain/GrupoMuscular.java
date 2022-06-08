package com.example.academiapw3.domain;

import java.util.Arrays;

public enum GrupoMuscular {
    ABDOMEN ("ABDOMEN", "Abdômen"),
    ANTEBRACO ("ANTEBRACO", "Antebraço"),
    BICEPS ("BICEPS", "Bíceps"),
    DELTOIDES ("DELTOIDES", "Deltóide"),
    OBLIQUOS ("OBLIQUOS", "Oblíquo"),
    TIBIALIS ("TIBIALIS", "Panturrilha"),
    PEITORAL ("PEITORAL", "Peito"),
    POSTERIOR ("POSTERIOR", "Posterior"),
    QUADRICEPS ("QUADRICEPS", "Quadríceps");

    private String musculo;
    private String sigla;

    GrupoMuscular(String sigla, String musculo) {
        this.sigla = sigla;
        this.musculo = musculo;
    }

    public static GrupoMuscular toEnum(String value) {
        return Arrays.stream(GrupoMuscular.values())
                .filter(c -> value.equals(c.toString()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return musculo;
    }

    public String getMusculo() {
        return musculo;
    }
}

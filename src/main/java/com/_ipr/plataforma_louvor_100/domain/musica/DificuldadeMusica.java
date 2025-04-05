package com._ipr.plataforma_louvor_100.domain.musica;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DificuldadeMusica {
    FACIL(0, "Fácil"),
    MEDIO(0, "Fácil"),
    DIFICIL(0, "Fácil");

    private final Integer codigo;
    private final String descricao;
}

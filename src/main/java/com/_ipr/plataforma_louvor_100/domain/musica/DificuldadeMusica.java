package com._ipr.plataforma_louvor_100.domain.musica;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DificuldadeMusica {
    FACIL(0, "Fácil"),
    MEDIA(1, "Média"),
    DIFICIL(2, "Dificil");

    private final Integer codigo;
    private final String descricao;
}

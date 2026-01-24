package com._ipr.plataforma_louvor_100.domain.musica;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Clima {
    CALMA(0, "Calma"),
    ALEGRE(1, "Alegre"),
    ANIMADA(2, "Animada");

    private final Integer codigo;
    private final String descricao;
}

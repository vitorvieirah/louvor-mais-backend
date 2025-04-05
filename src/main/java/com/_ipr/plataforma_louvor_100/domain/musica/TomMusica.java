package com._ipr.plataforma_louvor_100.domain.musica;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TomMusica {
    C("Dó"),
    D("Ré"),
    E("Mi"),
    F("Fá"),
    G("Sol"),
    A("Lá"),
    B("Sí");

    private final String descricao;
}

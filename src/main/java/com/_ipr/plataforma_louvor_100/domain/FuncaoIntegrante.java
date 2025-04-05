package com._ipr.plataforma_louvor_100.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum FuncaoIntegrante {
    GUITARRA(0, "Guitarra"),
    BATERIA(1, "Guitarra"),
    VIOLAO(2, "Guitarra"),
    TECLADO(3, "Guitarra"),
    BAIXO(4, "Guitarra"),
    MULTIINSTRUMENTALISTA(5, "Guitarra"),
    VOCAL(6, "Guitarra");

    private final Integer codigo;
    private final String descricao;
}

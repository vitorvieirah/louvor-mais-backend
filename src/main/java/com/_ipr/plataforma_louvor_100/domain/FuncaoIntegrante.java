package com._ipr.plataforma_louvor_100.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum FuncaoIntegrante {
    GUITARRA(0, "Guitarra"),
    BATERIA(1, "Bateria"),
    VIOLAO(2, "Violao"),
    TECLADO(3, "Teclado"),
    BAIXO(4, "Baixo"),
    MULTIINSTRUMENTALISTA(5, "Multiinstrumentista"),
    VOCAL(6, "Vocal");

    private final Integer codigo;
    private final String descricao;
}

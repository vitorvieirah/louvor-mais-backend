package com._ipr.plataforma_louvor_100.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Integrante {
    private UUID idIntegrante;
    private String nome;
    private FuncaoIntegrante funcao;
}

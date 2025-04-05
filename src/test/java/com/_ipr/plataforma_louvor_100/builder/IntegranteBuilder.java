package com._ipr.plataforma_louvor_100.builder;

import com._ipr.plataforma_louvor_100.domain.FuncaoIntegrante;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;

import java.util.UUID;

public class IntegranteBuilder {
    public static Integrante gerarIntegranteDomain() {
        return Integrante.builder()
                .idIntegrante(UUID.fromString("ebfd9cb3-b012-4aea-9545-94bfc6236fbc"))
                .nome("Integrante teste")
                .funcao(FuncaoIntegrante.BAIXO)
                .build();
    }

    public static IntegranteEntity gerarIntegranteEntity() {
        return IntegranteEntity.builder()
                .idIntegrante(UUID.fromString("ebfd9cb3-b012-4aea-9545-94bfc6236fbc"))
                .nome("Integrante teste")
                .funcao(FuncaoIntegrante.BAIXO)
                .build();
    }
}

package com._ipr.plataforma_louvor_100.builder;

import com._ipr.plataforma_louvor_100.domain.FuncaoIntegrante;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.IntegranteDto;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;

import java.util.ArrayList;
import java.util.List;
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

    public static List<Integrante> gerarListaIntegranteDomain() {
        List<Integrante> integranteList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            integranteList.add(gerarIntegranteDomain());
        }

        return integranteList;
    }

    public static List<IntegranteEntity> gerarListaIntegranteEntity() {
        List<IntegranteEntity> integranteList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            integranteList.add(gerarIntegranteEntity());
        }

        return integranteList;
    }

    public static IntegranteDto gerarIntegranteDto() {
        return IntegranteDto.builder()
                .idIntegrante(UUID.fromString("ebfd9cb3-b012-4aea-9545-94bfc6236fbc"))
                .nome("Integrante teste")
                .funcao(FuncaoIntegrante.BAIXO)
                .build();
    }

    public static String gerarJson() {
        Integrante integrante = gerarIntegranteDomain();
        return "{\"nome\": \"" + integrante.getNome()
                + "\", \"funcao\":\"" + integrante.getFuncao().getDescricao()
                + "\"}";
    }

    public static List<IntegranteDto> gerarListaIntegranteDto() {
        List<IntegranteDto> integranteList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            integranteList.add(gerarIntegranteDto());
        }

        return integranteList;
    }
}

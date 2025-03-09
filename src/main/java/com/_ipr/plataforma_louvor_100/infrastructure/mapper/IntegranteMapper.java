package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;

import java.util.List;

public class IntegranteMapper {

    public static Integrante paraDomain(IntegranteEntity entity) {
        return Integrante.builder()
                .idIntegrante(entity.getIdIntegrante())
                .nome(entity.getNome())
                .funcao(entity.getFuncao())
                .build();
    }

    public static IntegranteEntity paraEntity(Integrante domain) {
        return IntegranteEntity.builder()
                .idIntegrante(domain.getIdIntegrante())
                .nome(domain.getNome())
                .funcao(domain.getFuncao())
                .build();
    }

    public static List<Integrante> paraDomains(List<IntegranteEntity> entities) {
        return entities.stream().map(IntegranteMapper::paraDomain).toList();
    }

    public static List<IntegranteEntity> paraEntities(List<Integrante> domains) {
        return domains.stream().map(IntegranteMapper::paraEntity).toList();
    }
}

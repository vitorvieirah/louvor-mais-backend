package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;

public class SetlistMapper {

    public static Setlist paraDomain(SetlistEntity entity) {
        return Setlist.builder()
                .idSetlist(entity.getIdSetlist())
                .data(entity.getData())
                .musicas(MusicaMapper.paraDomains(entity.getMusicas()))
                .folgas(IntegranteMapper.paraDomains(entity.getFolgas()))
                .escalados(IntegranteMapper.paraDomains(entity.getEscalados()))
                .build();
    }

    public static SetlistEntity paraEntity(Setlist domain) {
        return SetlistEntity.builder()
                .idSetlist(domain.getIdSetlist())
                .data(domain.getData())
                .musicas(MusicaMapper.paraEntities(domain.getMusicas()))
                .folgas(IntegranteMapper.paraEntities(domain.getFolgas()))
                .escalados(IntegranteMapper.paraEntities(domain.getEscalados()))
                .build();
    }
}

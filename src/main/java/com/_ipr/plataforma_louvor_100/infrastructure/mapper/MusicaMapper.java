package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;

import java.util.List;

public class MusicaMapper {

    public static Musica paraDomain(MusicaEntity entity) {
        return Musica.builder()
                .idMusica(entity.getIdMusica())
                .nome(entity.getNome())
                .artista(entity.getArtista())
                .tom(entity.getTom())
                .clima(entity.getClima())
                .bpm(entity.getBpm())
                .compositor(entity.getCompositor())
                .link(entity.getLink())
                .cifra(entity.getCifra())
                .build();
    }

    public static MusicaEntity paraEntity(Musica domain) {
        return MusicaEntity.builder()
                .idMusica(domain.getIdMusica())
                .nome(domain.getNome())
                .artista(domain.getArtista())
                .tom(domain.getTom())
                .clima(domain.getClima())
                .bpm(domain.getBpm())
                .compositor(domain.getCompositor())
                .link(domain.getLink())
                .cifra(domain.getCifra())
                .build();
    }

    public static List<Musica> paraDomains(List<MusicaEntity> entities) {
        return entities.stream().map(MusicaMapper::paraDomain).toList();
    }

    public static List<MusicaEntity> paraEntities(List<Musica> domains) {
        return domains.stream().map(MusicaMapper::paraEntity).toList();
    }
}

package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;

import java.util.List;

public class MusicaMapper {

    public static Musica paraDomain(MusicaEntity entity) {
        return Musica.builder()
                .idMusica(entity.getIdMusica())
                .nome(entity.getNome())
                .tom(entity.getTom())
                .cifra(entity.getCifra())
                .link(entity.getLink())
                .dificuldade(entity.getDificuldade())
                .versao(entity.getVersao())
                .build();
    }

    public static MusicaEntity paraEntity(Musica domain) {
        return MusicaEntity.builder()
                .idMusica(domain.getIdMusica())
                .nome(domain.getNome())
                .tom(domain.getTom())
                .cifra(domain.getCifra())
                .link(domain.getLink())
                .dificuldade(domain.getDificuldade())
                .versao(domain.getVersao())
                .build();
    }

    public static List<Musica> paraDomains(List<MusicaEntity> entities) {
        return entities.stream().map(MusicaMapper::paraDomain).toList();
    }

    public static List<MusicaEntity> paraEntities(List<Musica> domains) {
        return domains.stream().map(MusicaMapper::paraEntity).toList();
    }
}

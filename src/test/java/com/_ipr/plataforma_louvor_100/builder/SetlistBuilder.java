package com._ipr.plataforma_louvor_100.builder;

import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.MusicaMapper;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SetlistBuilder {

    public static SetlistEntity gerarSetlistEntity() {
        List<MusicaEntity> musicaEntities = MusicaBuilder.gerarListaMusicaEntity();
        List<IntegranteEntity> integranteEntities = IntegranteBuilder.gerarListaIntegranteEntity();

        return SetlistEntity.builder()
                .idSetlist(UUID.fromString("87c3f0d7-c4c5-4b47-8fc9-9cac97a5eff4"))
                .data(LocalDate.now())
                .musicas(musicaEntities)
                .folgas(integranteEntities)
                .build();

    }

    public static Setlist gerarSetlistDomain() {
        List<Musica> musicas = MusicaBuilder.gerarListaMusicaDomain();
        List<Integrante> integrantes = IntegranteBuilder.gerarListaIntegranteDomain();

        return Setlist.builder()
                .idSetlist(UUID.fromString("87c3f0d7-c4c5-4b47-8fc9-9cac97a5eff4"))
                .data(LocalDate.now())
                .musicas(musicas)
                .folgas(integrantes)
                .build();
    }

    public static List<SetlistEntity> gerarListaSetlistEntity() {
        List<SetlistEntity> setlistEntities =  new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            setlistEntities.add(gerarSetlistEntity());
        }

        return setlistEntities;
    }

    public static Page<SetlistEntity> gerarPageSetlistEntity() {
        Pageable pageable = PageRequest.of(0, 10);

        List<SetlistEntity> list = gerarListaSetlistEntity();

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());

        List<SetlistEntity> sublist = list.subList(start, end);

        return new PageImpl<>(sublist, pageable, list.size());
    }
}

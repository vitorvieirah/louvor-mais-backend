package com._ipr.plataforma_louvor_100.builder;

import com._ipr.plataforma_louvor_100.domain.musica.DificuldadeMusica;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.MusicaMapper;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MusicaBuilder {

    public static Musica gerarMusicaDomain() {
        return Musica.builder()
                .idMusica(UUID.fromString("3544fce4-b2d5-497b-8f77-dda4fcd9e0fd"))
                .nome("Musica teste")
                .tom(TomMusica.D)
                .cifra("linkcifrateste")
                .dificuldade(DificuldadeMusica.FACIL)
                .link("linkdamusica")
                .versao("Versão teste")
                .build();

    }

    public static MusicaEntity gerarMusicaEntity() {
        return MusicaEntity.builder()
                .idMusica(UUID.fromString("3544fce4-b2d5-497b-8f77-dda4fcd9e0fd"))
                .nome("Musica teste")
                .tom(TomMusica.D)
                .cifra("linkcifrateste")
                .dificuldade(DificuldadeMusica.FACIL)
                .link("linkdamusica")
                .versao("Versão teste")
                .build();

    }

    public static List<Musica> gerarListaMusicaDomain() {
        List<Musica> musicas = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            musicas.add(gerarMusicaDomain());
        }

        return musicas;
    }

    public static List<MusicaEntity> gerarListaMusicaEntity() {
        List<MusicaEntity> musicas = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            musicas.add(gerarMusicaEntity());
        }

        return musicas;
    }

    public static Page<MusicaEntity> gerarPageMusicaEntity() {
        Pageable pageable = PageRequest.of(0, 10);

        List<MusicaEntity> list = MusicaMapper.paraEntities(gerarListaMusicaDomain());

        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), list.size());

        List<MusicaEntity> sublist = list.subList(start, end);

        return new PageImpl<>(sublist, pageable, list.size());
    }

    public static MusicaDto gerarMusicaDto() {
        return MusicaDto.builder()
                .idMusica(UUID.fromString("3544fce4-b2d5-497b-8f77-dda4fcd9e0fd"))
                .nome("Musica teste")
                .tom(TomMusica.D)
                .cifra("linkcifrateste")
                .dificuldade(DificuldadeMusica.FACIL)
                .link("linkdamusica")
                .versao("Versão teste")
                .build();
    }

    public static String gerarJson() {
        Musica musica = gerarMusicaDomain();
        return "{\"nome\": \"" + musica.getNome()
                + "\", \"tom\":\"" + musica.getTom()
                + "\", \"versao\":\"" + musica.getVersao()
                + "\", \"dificuldade\":\"" + musica.getDificuldade()
                + "\", \"link\":\"" + musica.getLink()
                + "\", \"cifra\":\"" + musica.getCifra() + "\"}";
    }

    public static List<MusicaDto> gerarLIstaMusicaDto() {
        List<MusicaDto> musicas = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            musicas.add(gerarMusicaDto());
        }

        return musicas;
    }
}

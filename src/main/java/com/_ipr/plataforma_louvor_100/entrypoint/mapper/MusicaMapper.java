package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;

public class MusicaMapper {

    public static Musica paraDomain(MusicaDto dto) {
        return Musica.builder()
                .idMusica(dto.idMusica())
                .nome(dto.nome())
                .tom(dto.tom())
                .cifra(dto.cifra())
                .dificuldade(dto.dificuldade())
                .link(dto.link())
                .versao(dto.versao())
                .build();
    }

    public static MusicaDto paraDto(Musica domain) {
        return MusicaDto.builder()
                .idMusica(domain.getIdMusica())
                .nome(domain.getNome())
                .tom(domain.getTom())
                .descricaoTom(domain.getTom().getDescricao())
                .cifra(domain.getCifra())
                .dificuldade(domain.getDificuldade())
                .descricaoDificuldade(domain.getDificuldade().getDescricao())
                .link(domain.getLink())
                .versao(domain.getVersao())
                .build();
    }
}

package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaResponseDto;

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

    public static MusicaResponseDto paraDto(Musica domain) {
        return MusicaResponseDto.builder()
                .idMusica(domain.getIdMusica())
                .nome(domain.getNome())
                .tom(domain.getTom().getDescricao())
                .cifra(domain.getCifra())
                .dificuldade(domain.getDificuldade().getDescricao())
                .link(domain.getLink())
                .versao(domain.getVersao())
                .build();
    }
}

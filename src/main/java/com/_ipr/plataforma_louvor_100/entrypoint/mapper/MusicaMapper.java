package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;

public class MusicaMapper {

    public static Musica paraDomain(MusicaDto dto) {
        return Musica.builder()
                .idMusica(dto.idMusica())
                .nome(dto.nome())
                .artista(dto.artista())
                .tom(dto.tom())
                .clima(dto.clima())
                .bpm(dto.bpm())
                .compositor(dto.compositor())
                .link(dto.link())
                .cifra(dto.cifra())
                .build();
    }

    public static MusicaDto paraDto(Musica domain) {
        return MusicaDto.builder()
                .idMusica(domain.getIdMusica())
                .nome(domain.getNome())
                .artista(domain.getArtista())
                .tom(domain.getTom())
                .descricaoTom(domain.getTom().getDescricao())
                .clima(domain.getClima())
                .descricaoClima(domain.getClima().getDescricao())
                .bpm(domain.getBpm())
                .compositor(domain.getCompositor())
                .link(domain.getLink())
                .cifra(domain.getCifra())
                .build();
    }
}

package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.entrypoint.dto.SetlistDto;

public class SetlistMapper {

    public static Setlist paraDomain(SetlistDto dto) {
        return Setlist.builder()
                .idSetlist(dto.idSetlist())
                .data(dto.data())
                .musicas(dto.musicas())
                .folgas(dto.folgas())
                .build();
    }

    public static SetlistDto paraDto(Setlist domain) {
        return SetlistDto.builder()
                .idSetlist(domain.getIdSetlist())
                .data(domain.getData())
                .musicas(domain.getMusicas())
                .folgas(domain.getFolgas())
                .build();
    }
}

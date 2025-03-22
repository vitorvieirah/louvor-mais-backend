package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicaMapperTest {

    private final Musica musicaTesteDomain = MusicaBuilder.gerarMusicaDomain();
    private final MusicaDto musicaTesteDto = MusicaBuilder.gerarMusicaDto();

    @Test
    void converterDtoParaDomain() {
        MusicaValidator.validaMusicaDomain(MusicaMapper.paraDomain(musicaTesteDto), musicaTesteDomain);
    }

    @Test
    void converterDomainParaDto() {
        MusicaValidator.validaMusicaDto(MusicaMapper.paraDto(musicaTesteDomain), musicaTesteDto);
    }
}
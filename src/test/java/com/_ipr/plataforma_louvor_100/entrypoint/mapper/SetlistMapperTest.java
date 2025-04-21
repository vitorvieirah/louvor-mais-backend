package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.builder.SetlistBuilder;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.entrypoint.dto.SetlistDto;
import com._ipr.plataforma_louvor_100.validators.SetlistValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetlistMapperTest {

    private final Setlist setlistDomain = SetlistBuilder.gerarSetlistDomain();
    private final SetlistDto setlistDto = SetlistBuilder.gerarSetlistDto();

    @Test
    void testeEntityparaDomain() {
        SetlistValidator.validaSetlistDomainMapper(SetlistMapper.paraDomain(setlistDto), setlistDto);
    }

    @Test
    void testeDomainParaDto() {
        SetlistValidator.validaSetlistDtoMapper(SetlistMapper.paraDto(setlistDomain), setlistDomain);
    }
}
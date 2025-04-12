package com._ipr.plataforma_louvor_100.entrypoint.mapper;

import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.entrypoint.dto.IntegranteDto;
import com._ipr.plataforma_louvor_100.validators.IntegranteValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegranteMapperTest {

    private final Integrante integranteTesteDomain = IntegranteBuilder.gerarIntegranteDomain();
    private final IntegranteDto integranteTesteDto = IntegranteBuilder.gerarIntegranteDto();

    @Test
    void testeConversaoDtoParaDomain() {
        IntegranteValidator.validaIntegranteDomainMapper(IntegranteMapper.paraDomain(integranteTesteDto), integranteTesteDto);
    }

    @Test
    void testeConversaoDomainParaDto() {
        IntegranteValidator.validaIntegranteDtoMapper(IntegranteMapper.paraDto(integranteTesteDomain), integranteTesteDomain);
    }
}
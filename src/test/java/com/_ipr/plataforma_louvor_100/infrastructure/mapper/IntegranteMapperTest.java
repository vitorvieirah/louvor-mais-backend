package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import com._ipr.plataforma_louvor_100.validators.IntegranteValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class IntegranteMapperTest {

    private final Integrante integranteTeste = IntegranteBuilder.gerarIntegranteDomain();
    private final IntegranteEntity integranteTesteEntity = IntegranteBuilder.gerarIntegranteEntity();
    private final List<Integrante> integranteDomainList = IntegranteBuilder.gerarListaIntegranteDomain();
    private final List<IntegranteEntity> integranteEntityList = IntegranteBuilder.gerarListaIntegranteEntity();

    @Test
    void testaEntityParaDomain() {
        Integrante resultado = IntegranteMapper.paraDomain(integranteTesteEntity);
        IntegranteValidator.validaIntegranteDomainMapper(resultado, integranteTesteEntity);
        Assertions.assertEquals(resultado.getIdIntegrante(), integranteTesteEntity.getIdIntegrante());
    }

    @Test
    void testaDomainParaEntity() {
        IntegranteEntity resultado = IntegranteMapper.paraEntity(integranteTeste);
        IntegranteValidator.validaIntegranteEntityMapper(resultado, integranteTeste);
        Assertions.assertEquals(resultado.getIdIntegrante(), integranteTeste.getIdIntegrante());
    }

    @Test
    void testaEntitiesParaDomains() {
        List<Integrante> resultado = IntegranteMapper.paraDomains(integranteEntityList);

        for (int i = 0; i < resultado.size(); i++) {
            IntegranteValidator.validaIntegranteDomainMapper(resultado.get(i), integranteEntityList.get(i));
            Assertions.assertEquals(resultado.get(i).getIdIntegrante().toString(), integranteEntityList.get(i).getIdIntegrante().toString());
        }

        Assertions.assertEquals(integranteEntityList.size(), resultado.size());
    }

    @Test
    void testaDomainsParaEntities() {
        List<IntegranteEntity> resultado = IntegranteMapper.paraEntities(integranteDomainList);

        for (int i = 0; i < resultado.size(); i++) {
            IntegranteValidator.validaIntegranteEntityMapper(resultado.get(i), integranteDomainList.get(i));
            Assertions.assertEquals(resultado.get(i).getIdIntegrante().toString(), integranteEntityList.get(i).getIdIntegrante().toString());
        }

        Assertions.assertEquals(integranteDomainList.size(), resultado.size());
    }
}
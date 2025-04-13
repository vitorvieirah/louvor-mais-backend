package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.builder.SetlistBuilder;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import com._ipr.plataforma_louvor_100.validators.SetlistValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetlistMapperTest {

    private final SetlistEntity setlistEntityTeste = SetlistBuilder.gerarSetlistEntity();
    private final Setlist setlistDomainTeste = SetlistBuilder.gerarSetlistDomain();

    @Test
    void testeConversaoEntityParaDomain() {
        SetlistValidator.validaSetlistDomainMapper(SetlistMapper.paraDomain(setlistEntityTeste), setlistEntityTeste);
    }

    @Test
    void testeConversaoDomainParaEntity() {
        SetlistValidator.validaSetlistEntityMapper(SetlistMapper.paraEntity(setlistDomainTeste), setlistDomainTeste);
    }
}
package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MusicaMapperTest {

    private final Musica musicaTeste = MusicaBuilder.gerarMusica();
    private final List<Musica> musicas = MusicaBuilder.gerarListaMusica();

    @Test
    void coverteDomainParaEntity() {
        MusicaEntity resultado = MusicaMapper.paraEntity(musicaTeste);
        MusicaValidator.validaMusica(MusicaMapper.paraDomain(resultado));
    }

    @Test
    void converteEntityParaDomain() {
        Musica resultado = MusicaMapper.paraDomain(MusicaMapper.paraEntity(musicaTeste));
        MusicaValidator.validaMusica(resultado);
    }

    @Test
    void converListaDeEntitiesParaListaDeDomains() {
        List<MusicaEntity> resultado = MusicaMapper.paraEntities(musicas);
        resultado.forEach(musicaTeste -> MusicaValidator.validaMusica(MusicaMapper.paraDomain(musicaTeste)));
    }

    @Test
    void converterListaDeDomainsParaListaDeEntities() {
        List<Musica> resultado = MusicaMapper.paraDomains(MusicaMapper.paraEntities(musicas));
        resultado.forEach(MusicaValidator::validaMusica);
    }

}

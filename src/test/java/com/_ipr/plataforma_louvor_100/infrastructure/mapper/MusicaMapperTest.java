package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MusicaMapperTest {

    private final Musica musicaTesteDomain = MusicaBuilder.gerarMusicaDomain();
    private final MusicaEntity musicaTesteEntity = MusicaBuilder.gerarMusicaEntity();
    private final List<Musica> musicas = MusicaBuilder.gerarListaMusica();

    @Test
    void coverteDomainParaEntity() {
        MusicaValidator.validaMusicaEntity(MusicaMapper.paraEntity(musicaTesteDomain), musicaTesteEntity);
    }

    @Test
    void converteEntityParaDomain() {
        Musica resultado = MusicaMapper.paraDomain(musicaTesteEntity);
        MusicaValidator.validaMusicaDomain(resultado, musicaTesteDomain);
    }

    @Test
    void converListaDeEntitiesParaListaDeDomains() {
        List<Musica> resultado = MusicaMapper.paraDomains(musicas.stream().map(MusicaMapper::paraEntity).toList());
        resultado.forEach(musica -> MusicaValidator.validaMusicaDomain(musica, musicaTesteDomain));
    }

    @Test
    void converterListaDeDomainsParaListaDeEntities() {
        List<MusicaEntity> resultado = MusicaMapper.paraEntities(musicas);
        resultado.forEach(musica -> MusicaValidator.validaMusicaEntity(musica, musicaTesteEntity));
    }

}

package com._ipr.plataforma_louvor_100.infrastructure.mapper;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MusicaMapperTest {

    private final Musica musicaTesteDomain = MusicaBuilder.gerarMusicaDomain();
    private final MusicaEntity musicaTesteEntity = MusicaBuilder.gerarMusicaEntity();
    private final List<Musica> musicaDomainList = MusicaBuilder.gerarListaMusicaDomain();
    private final List<MusicaEntity> musicaEntityList = MusicaBuilder.gerarListaMusicaEntity();

    @Test
    void coverteDomainParaEntity() {
        MusicaEntity resultado = MusicaMapper.paraEntity(musicaTesteDomain);
        MusicaValidator.validaMusicaEntityMapper(resultado, musicaTesteDomain);
        Assertions.assertEquals(resultado.getIdMusica(), musicaTesteDomain.getIdMusica());
    }

    @Test
    void converteEntityParaDomain() {
        Musica resultado = MusicaMapper.paraDomain(musicaTesteEntity);
        MusicaValidator.validaMusicaDomainMapper(resultado, musicaTesteEntity);
        Assertions.assertEquals(resultado.getIdMusica(), musicaTesteEntity.getIdMusica());
    }

    @Test
    void converListaDeEntitiesParaListaDeDomains() {
        List<Musica> resultado = MusicaMapper.paraDomains(musicaEntityList);

        for (int i = 0; i < resultado.size(); i++) {
            MusicaValidator.validaMusicaDomainMapper(resultado.get(i), musicaEntityList.get(i));
            Assertions.assertEquals(resultado.get(i).getIdMusica().toString(), musicaEntityList.get(i).getIdMusica().toString());
        }

        Assertions.assertEquals(resultado.size(), musicaEntityList.size());
    }

    @Test
    void converterListaDeDomainsParaListaDeEntities() {
        List<MusicaEntity> resultado = MusicaMapper.paraEntities(musicaDomainList);

        for (int i = 0; i < resultado.size(); i++) {
            MusicaValidator.validaMusicaEntityMapper(resultado.get(i), musicaDomainList.get(i));
            Assertions.assertEquals(resultado.get(i).getIdMusica().toString(), musicaDomainList.get(i).getIdMusica().toString());
        }

        Assertions.assertEquals(resultado.size(), musicaDomainList.size());
    }

}

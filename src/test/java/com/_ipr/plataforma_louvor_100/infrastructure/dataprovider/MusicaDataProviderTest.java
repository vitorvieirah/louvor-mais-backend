package com._ipr.plataforma_louvor_100.infrastructure.dataprovider;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.exceptions.DataProviderException;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.MusicaRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MusicaDataProviderTest {

    @Mock
    private MusicaRepository repository;

    @InjectMocks
    private MusicaDataProvider dataProvider;

    private final Musica musicaTeste = MusicaBuilder.gerarMusicaDomain();

    private final MusicaEntity musicaTesteEntity = MusicaBuilder.gerarMusicaEntity();

    private final Page<MusicaEntity> musicasEntities = MusicaBuilder.gerarPageMusicaEntity();

    @Test
    void testeSalvaMusica() {
        Mockito.when(repository.save(Mockito.any())).thenReturn(musicaTesteEntity);
        musicaTeste.setIdMusica(null);
        Musica resultado = dataProvider.salvar(musicaTeste);
        MusicaValidator.validaMusicaDomain(resultado, musicaTeste);
        Assertions.assertNotNull(resultado.getIdMusica());
    }

    @Test
    void testaExceptionSalvaMusica() {
        Mockito.when(repository.save(Mockito.any())).thenThrow(RuntimeException.class);
        DataProviderException exception = Assertions
                .assertThrows(DataProviderException.class, () -> dataProvider.salvar(musicaTeste));
        Assertions.assertEquals(exception.getMessage(), dataProvider.MENSAGEM_ERRO_SALVAR_MUSICA);
    }

    @Test
    void testaConsultarMuiscaPorId() {
        Mockito.when(repository.findById(Mockito.any())).thenReturn(Optional.of(musicaTesteEntity));
        Optional<Musica> resultado = dataProvider.consultarPorId(musicaTeste.getIdMusica());

        resultado.ifPresent(musica -> {
            MusicaValidator.validaMusicaDomain(musica, musicaTeste);
            Assertions.assertEquals(musica.getIdMusica(), musicaTeste.getIdMusica());
        });
    }

    @Test
    void testaExceptionConsultaMusicaPorId() {
        Mockito.when(repository.findById(Mockito.any())).thenThrow(RuntimeException.class);
        DataProviderException exception = Assertions
                .assertThrows(DataProviderException.class, () -> dataProvider.consultarPorId(musicaTeste.getIdMusica()));
        Assertions.assertEquals(exception.getMessage(), dataProvider.MENSAGEM_ERRO_CONSULTAR_MUSICA_ID);
    }

    @Test
    void testaListagemMusicas() {
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(repository.findAll(pageable)).thenReturn(musicasEntities);

        Page<Musica> resultado = dataProvider.listar(pageable);

        resultado.forEach(musica -> {
            MusicaValidator.validaMusicaDomain(musica, musicaTeste);
            Assertions.assertEquals(musica.getIdMusica(), musicaTeste.getIdMusica());
        });
    }

    @Test
    void testaExceptionListagemMusicas() {
        Pageable pageable = PageRequest.of(0, 10);
        Mockito.when(repository.findAll(pageable)).thenThrow(RuntimeException.class);

        DataProviderException exception = Assertions
                .assertThrows(DataProviderException.class, () -> dataProvider.listar(pageable));
        Assertions.assertEquals(exception.getMessage(), dataProvider.MENSAGEM_ERRO_LISTAR_MUSICA);
    }

    @Test
    void testaConsultarMusicaPorNome() {
        Mockito.when(repository.findByNome(Mockito.any())).thenReturn(Optional.of(musicaTesteEntity));
        Optional<Musica> resultado = dataProvider.consultarPorNome(musicaTeste.getNome());

        resultado.ifPresent(musica -> {
            MusicaValidator.validaMusicaDomain(musica, musicaTeste);
            Assertions.assertEquals(musica.getIdMusica(), musicaTeste.getIdMusica());
        });
    }

    @Test
    void testaExceptionConsultarMusicaPorNome() {
        Mockito.when(repository.findByNome(Mockito.any())).thenThrow(RuntimeException.class);
        DataProviderException exception = Assertions
                .assertThrows(DataProviderException.class, () -> dataProvider.consultarPorNome(musicaTeste.getNome()));
        Assertions.assertEquals(exception.getMessage(), dataProvider.MENSAGEM_ERRO_CONSULTAR_MUSICA_NOME);
    }
}
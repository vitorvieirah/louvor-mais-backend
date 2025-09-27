package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.exceptions.musica.MusicaJaCadastradaException;
import com._ipr.plataforma_louvor_100.aplication.exceptions.musica.MusicaNaoEncontradaException;
import com._ipr.plataforma_louvor_100.aplication.gateways.MusicaGateway;
import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.DificuldadeMusica;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;
import com._ipr.plataforma_louvor_100.infrastructure.mapper.MusicaMapper;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class MusicaUseCaseTest {

    @Mock
    private MusicaGateway gateway;

    @InjectMocks
    private MusicaUseCase useCase;

    @Captor
    private ArgumentCaptor<Musica> captor;

    private final Musica musicaTeste = MusicaBuilder.gerarMusicaDomain();

    @Test
    void testaCadastroMusica() {

        Mockito.when(gateway.consultarPorNome(Mockito.any())).thenReturn(Optional.empty());

        Mockito.when(gateway.salvar(captor.capture())).thenReturn(musicaTeste);

        musicaTeste.setIdMusica(null);

        useCase.cadastrar(musicaTeste);

        Musica resultado = captor.getValue();


        MusicaValidator.validaMusicaDomain(resultado, musicaTeste);
        Assertions.assertNull(resultado.getIdMusica());
    }

    @Test
    void testaExceptionCadastroMusica() {

        Mockito.when(gateway.consultarPorNome(Mockito.any())).thenReturn(Optional.of(musicaTeste));

        musicaTeste.setIdMusica(null);

        MusicaJaCadastradaException exception = Assertions
                .assertThrows(MusicaJaCadastradaException.class, () -> useCase.cadastrar(musicaTeste));

        Assertions.assertEquals(exception.getMessage(), "Música já cadastrada com esse nome.");
    }

    @Test
    void testaConsultaPsicologoPorId() {
        Mockito.when(gateway.consultarPorId(Mockito.any())).thenReturn(Optional.of(musicaTeste));

        Musica resultado = useCase.consultarPorId(musicaTeste.getIdMusica());

        MusicaValidator.validaMusicaDomain(resultado, musicaTeste);
        Assertions.assertEquals(resultado.getIdMusica(), musicaTeste.getIdMusica());
    }

    @Test
    void testaExceptionConsultaPsicologoPorId() {
        Mockito.when(gateway.consultarPorId(Mockito.any())).thenReturn(Optional.empty());

        MusicaNaoEncontradaException exception = Assertions
                .assertThrows(MusicaNaoEncontradaException.class, () -> useCase.consultarPorId(musicaTeste.getIdMusica()));

        Assertions.assertEquals(exception.getMessage(), "Música não encontrada com esse id.");
    }


    @Test
    void testaListagemDeMusicas() {
        Page<Musica> musicas = MusicaBuilder.gerarPageMusicaEntity().map(MusicaMapper::paraDomain);
        Mockito.when(gateway.listar(Mockito.any())).thenReturn(musicas);

        Page<Musica> resultado = useCase.listar(PageRequest.of(0,10));

        resultado.forEach(musica -> {
            MusicaValidator.validaMusicaDomain(musica, musicaTeste);
            Assertions.assertEquals(musica.getIdMusica(), musicaTeste.getIdMusica());
        });
    }

    @Test
    void testaEdicaoDeMusica() {
        Mockito.when(gateway.consultarPorId(Mockito.any())).thenReturn(Optional.of(musicaTeste));
        Mockito.when(gateway.salvar(captor.capture())).thenReturn(musicaTeste);

        Musica musica = Musica
                .builder()
                .nome("Novo nome")
                .tom(TomMusica.E)
                .versao("versão editada nova")
                .dificuldade(DificuldadeMusica.MEDIA)
                .link("linknovoedicao")
                .cifra("cifra nova edição")
                .build();

        useCase.editar(musica, musicaTeste.getIdMusica());

        Musica resultado = captor.getValue();

        MusicaValidator.validaMusicaDomain(resultado, musica);
        Assertions.assertEquals(resultado.getIdMusica(), musicaTeste.getIdMusica());
    }
}
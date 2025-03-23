package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.aplication.gateways.MusicaGateway;
import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.MusicaDataProvider;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
    void testeCadastroMusica() {

        Mockito.when(gateway.consultarPorId(Mockito.any())).thenReturn(Optional.empty());

        Mockito.when(gateway.salvar(captor.capture())).thenReturn(musicaTeste);

        musicaTeste.setIdMusica(null);

        useCase.cadastrar(musicaTeste);

        Musica resultado = captor.getValue();


        MusicaValidator.validaMusicaDomain(resultado, musicaTeste);
        Assertions.assertNull(resultado.getIdMusica());
    }

    @Test
    void consultarPorId() {
    }

    @Test
    void listar() {
    }

    @Test
    void editar() {
    }
}
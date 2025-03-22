package com._ipr.plataforma_louvor_100.aplication;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.dataprovider.MusicaDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MusicaUseCaseTest {

    @Mock
    private MusicaDataProvider dataProvider;

    @InjectMocks
    private MusicaUseCase useCase;

    @Captor
    private ArgumentCaptor<Musica> captor;

    private

    @Test
    void testeCadastroMusica() {

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
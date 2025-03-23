package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.MusicaRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class MusicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MusicaRepository repository;

    @InjectMocks
    private MusicaController musicaController;

    private final MusicaEntity musicaTesteEntity = MusicaBuilder.gerarMusicaEntity();

    private final String MUSICA_JSON = MusicaBuilder.gerarJson();

    @Test
    void testaCadastroDeMusicas() throws Exception {
        Mockito.when(repository.findByNome(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(repository.save(Mockito.any())).thenReturn(musicaTesteEntity);

        ResultActions resultado = mockMvc
                .perform(MockMvcRequestBuilders.post("/musicas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MUSICA_JSON)
                );

        resultado.andExpect(MockMvcResultMatchers.status().isCreated());
        MusicaValidator.validaMusicaController(resultado, MusicaBuilder.gerarMusicaDomain());
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

    @Test
    void deletar() {
    }
}
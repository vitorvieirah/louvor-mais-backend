package com._ipr.plataforma_louvor_100.entrypoint.controller.middleware;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.MusicaRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MusicaHandlerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private MusicaRepository repository;

    private final MusicaEntity musicaTeste = MusicaBuilder.gerarMusicaEntity();

    private final String MUSICA_JSON = MusicaBuilder.gerarJson();

    @Test
    void testaExceptionMusicaJaCadastradaExceptionHandler() throws Exception {
        musicaTeste.setIdMusica(null);
        when(repository.findByNome(Mockito.any())).thenReturn(Optional.of(musicaTeste));
        when(repository.save(musicaTeste)).thenReturn(musicaTeste);

        ResultActions resultadoRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.post("/musicas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MUSICA_JSON));

        resultadoRequisicao.andExpect(MockMvcResultMatchers.status().isBadRequest());

        resultadoRequisicao.andExpect(MockMvcResultMatchers.jsonPath("$.erro.mensagens[0]").value("Música já cadastrada com esse nome."));
    }

    @Test
    void testaExceptionMusicaNaoEncontradaExceptionHandler() throws Exception {
        when(repository.findById(musicaTeste.getIdMusica())).thenReturn(Optional.empty());

        ResultActions resultadoRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.get("/musicas/{id}", musicaTeste.getIdMusica())
                        .contentType(MediaType.APPLICATION_JSON)
                );

        resultadoRequisicao.andExpect(MockMvcResultMatchers.status().isNotFound());

        resultadoRequisicao.andExpect(MockMvcResultMatchers.jsonPath("$.erro.mensagens[0]").value("Música não encontrada com esse id."));
    }

    @Test
    void testaExceptionMethodArgumentNotValidExceptionHandler() throws Exception {
        Musica musica = MusicaBuilder.gerarMusicaDomain();
        String requestBody =  "{\"nome\": \""
                + "\", \"tom\":\"" + musica.getTom()
                + "\", \"versao\":\"" + musica.getVersao()
                + "\", \"dificuldade\":\"" + musica.getDificuldade()
                + "\", \"link\":\"" + musica.getLink()
                + "\", \"cifra\":\"" + musica.getCifra() + "\"}";

        musicaTeste.setIdMusica(null);

        when(repository.findByNome(Mockito.any())).thenReturn(Optional.empty());
        when(repository.save(musicaTeste)).thenReturn(musicaTeste);

        ResultActions resultadoRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.post("/musicas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                );

        resultadoRequisicao.andExpect(status().isBadRequest());
        resultadoRequisicao.andExpect(MockMvcResultMatchers.jsonPath("$.erro.mensagens[0]").value("O nome é obrigatório"));
    }
}
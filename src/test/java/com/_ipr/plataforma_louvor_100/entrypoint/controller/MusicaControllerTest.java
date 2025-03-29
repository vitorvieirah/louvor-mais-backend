package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.DificuldadeMusica;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.MusicaRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import com._ipr.plataforma_louvor_100.validators.MusicaValidator;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MusicaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private MusicaRepository repository;

    private final MusicaEntity musicaTesteEntity = MusicaBuilder.gerarMusicaEntity();

    private final String MUSICA_JSON = MusicaBuilder.gerarJson();

    @Test
    void testaCadastroDeMusicas() throws Exception {
        musicaTesteEntity.setIdMusica(null);

        Mockito.when(repository.findByNome(Mockito.any())).thenReturn(Optional.empty());
        Mockito.when(repository.save(musicaTesteEntity)).thenReturn(musicaTesteEntity);

        ResultActions resultado = mockMvc
                .perform(MockMvcRequestBuilders.post("/musicas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MUSICA_JSON)
                );

        resultado.andExpect(MockMvcResultMatchers.status().isCreated());
        MusicaValidator.validaMusicaController(resultado, MusicaBuilder.gerarMusicaDomain());
    }

    @Test
    void testeConsultaMusicaPorId() throws Exception {
        UUID idTeste = musicaTesteEntity.getIdMusica();

        Mockito.when(repository.findById(idTeste)).thenReturn(Optional.of(musicaTesteEntity));

        ResultActions resultado = mockMvc
                .perform(MockMvcRequestBuilders.get("/musicas/{id}", idTeste)
                        .contentType(MediaType.APPLICATION_JSON)
                );

        resultado.andExpect(MockMvcResultMatchers.status().isOk());
        resultado.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        MusicaValidator.validaMusicaController(resultado, MusicaBuilder.gerarMusicaDomain());
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.id_musica").value(idTeste.toString().trim()));
    }

    @Test
    void testaListagemDeMusicas() throws Exception {
        Page<MusicaEntity> musicaEntities = MusicaBuilder.gerarPageMusicaEntity();

        Pageable pageableTeste = PageRequest.of(1, 10);

        Mockito.when(repository.findAll(pageableTeste)).thenReturn(musicaEntities);

        ResultActions resultado = mockMvc
                .perform(MockMvcRequestBuilders.get("/musicas")
                        .param("page", "1")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON)
                );

        resultado.andExpect(MockMvcResultMatchers.status().isOk());
        resultado.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        List<MusicaEntity> listMusicas = musicaEntities.getContent();
        int totalMusicas = listMusicas.size();

        System.out.println("Page: ");
        musicaEntities.stream().forEach(System.out::println);
        System.out.println("List: ");
        listMusicas.forEach(System.out::println);

        for (int i = 0; i < totalMusicas; i++) {
            MusicaValidator.validaMusicasController(resultado, i, listMusicas.get(i));
        }
    }

    //problema
    @Test
    void testaEdicaoDeMusica() throws Exception {
        UUID idTeste = musicaTesteEntity.getIdMusica();
        musicaTesteEntity.setIdMusica(null);
        MusicaEntity musicaExistente = MusicaEntity.builder()
                .idMusica(idTeste)
                .tom(TomMusica.C)
                .nome("Nome existente teste")
                .link("link existente teste")
                .dificuldade(DificuldadeMusica.MEDIO)
                .cifra("cifra existente teste")
                .versao("versão existente teste")
                .build();

        Mockito.when(repository.findById(idTeste)).thenReturn(Optional.of(musicaExistente));
        Mockito.when(repository.save(musicaTesteEntity)).thenReturn(musicaTesteEntity);

        ResultActions resultado = mockMvc
                .perform(MockMvcRequestBuilders.put("/musicas/{id}", idTeste)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(MUSICA_JSON)
                );

        resultado.andExpect(MockMvcResultMatchers.status().isOk());
        resultado.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));

        MusicaValidator.validaMusicaController(resultado, MusicaBuilder.gerarMusicaDomain());
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.id_musica").value(idTeste.toString().trim()));
    }

    @Test
    void deletar() {
    }
}
package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.builder.SetlistBuilder;
import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.entrypoint.mapper.SetlistMapper;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.IntegranteRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.MusicaRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.SetlistRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import com._ipr.plataforma_louvor_100.validators.SetlistValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
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

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SetlistControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private SetlistRepository repository;

    @MockitoSpyBean
    private MusicaRepository musicaRepository;

    @MockitoSpyBean
    private IntegranteRepository integranteRepository;

    private SetlistEntity setlistEntity;

    private final String SETLIST_JSON = SetlistBuilder.gerarJson();

    @BeforeEach
    void setUp() {
        this.setlistEntity = SetlistBuilder.gerarSetlistEntity();
    }


//    @Test
//    void testeCadastroDeSetlist() throws Exception {
//        Mockito.when(repository.save(Mockito.any())).thenReturn(setlistEntity);
//        Mockito.when(integranteRepository.findById(Mockito.any())).thenReturn(Optional.of(IntegranteBuilder.gerarIntegranteEntity()));
//        Mockito.when(musicaRepository.find)
//
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//
//        String setlistJson = SetlistBuilder.gerarJson();
//
//        ResultActions resultado = mockMvc
//                .perform(MockMvcRequestBuilders.post("/setlists")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(setlistJson)
//                );
//
//        resultado.andExpect(MockMvcResultMatchers.status().isCreated());
//        SetlistValidator.validaSetlistController(resultado, );
//    }

//    @Test
//    void testaListagemDeSetlists() throws Exception {
//        Page<SetlistEntity> pageTeste = SetlistBuilder.gerarPageSetlistEntity();
//
//        Pageable pageable = PageRequest.of(0, 10);
//        Mockito.when(repository.findAll(pageable)).thenReturn(pageTeste);
//
//        ResultActions resultado = mockMvc
//                .perform(MockMvcRequestBuilders.get("/setlists")
//                        .param("page", String.valueOf(0))
//                        .param("size", String.valueOf(10))
//                ).andExpect(MockMvcResultMatchers.status().isOk());
//
//        for (int i = 0; i < 3; i++) {
//            SetlistValidator.validaSetlistsController(resultado, SetlistBuilder.gerarSetlistEntity(), i);
//        }
//    }
}
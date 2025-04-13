package com._ipr.plataforma_louvor_100.entrypoint.controller;

import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.IntegranteRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import com._ipr.plataforma_louvor_100.validators.IntegranteValidator;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class IntegranteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private IntegranteRepository repository;

    private final IntegranteEntity integranteTesteEntity = IntegranteBuilder.gerarIntegranteEntity();

    private final String INTEGRANTE_JSON = IntegranteBuilder.gerarJson();

    @Test
    void testeCadastrar() throws Exception {
        integranteTesteEntity.setIdIntegrante(null);

        Mockito.when(repository.findByNome(integranteTesteEntity.getNome())).thenReturn(Optional.empty());
        Mockito.when(repository.save(integranteTesteEntity)).thenReturn(integranteTesteEntity);

        ResultActions resultado = mockMvc
                .perform(MockMvcRequestBuilders.post("/integrantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(INTEGRANTE_JSON)
                );

        resultado.andExpect(MockMvcResultMatchers.status().isCreated());
        IntegranteValidator.validaIntegranteController(resultado, IntegranteBuilder.gerarIntegranteDomain());
    }
}
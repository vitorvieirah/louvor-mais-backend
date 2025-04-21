package com._ipr.plataforma_louvor_100.entrypoint.controller.middleware;

import com._ipr.plataforma_louvor_100.builder.IntegranteBuilder;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.IntegranteRepository;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
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

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class IntegranteHandlerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoSpyBean
    private IntegranteRepository repository;

    private final IntegranteEntity integranteTeste = IntegranteBuilder.gerarIntegranteEntity();

    private final String INTEGRANTE_JSON = IntegranteBuilder.gerarJson();

    @Test
    void testaExceptionIntegranteJaCadastradaExceptionHandler() throws Exception {
        integranteTeste.setIdIntegrante(null);
        when(repository.findByNome(Mockito.any())).thenReturn(Optional.of(integranteTeste));
        when(repository.save(integranteTeste)).thenReturn(integranteTeste);

        ResultActions resultadoRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.post("/integrantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(INTEGRANTE_JSON));

        resultadoRequisicao.andExpect(MockMvcResultMatchers.status().isBadRequest());

        resultadoRequisicao.andExpect(MockMvcResultMatchers.jsonPath("$.erro.mensagens[0]").value("Integrante já cadastrado com esse nome."));
    }

    @Test
    void integranteNaoEncontradoExceptionHandler() {
    }
}
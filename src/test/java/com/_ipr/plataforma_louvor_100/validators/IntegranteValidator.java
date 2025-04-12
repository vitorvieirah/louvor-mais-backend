package com._ipr.plataforma_louvor_100.validators;

import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.entrypoint.dto.IntegranteDto;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.IntegranteEntity;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class IntegranteValidator {

    public static void validaIntegranteDomain(Integrante resultado, Integrante integranteTeste) {
        Assertions.assertEquals(resultado.getNome(), integranteTeste.getNome());
        Assertions.assertEquals(resultado.getFuncao().toString(), integranteTeste.getFuncao().toString());
    }

    public static void validaIntegranteDomainMapper(Integrante resultado, IntegranteEntity integranteTeste) {
        Assertions.assertEquals(resultado.getNome(), integranteTeste.getNome());
        Assertions.assertEquals(resultado.getFuncao().toString(), integranteTeste.getFuncao().toString());
    }

    public static void validaIntegranteEntityMapper(IntegranteEntity resultado, Integrante integranteTeste) {
        Assertions.assertEquals(resultado.getNome(), integranteTeste.getNome());
        Assertions.assertEquals(resultado.getFuncao().toString(), integranteTeste.getFuncao().toString());
    }

    public static void validaIntegranteDomainMapper(Integrante resultado, IntegranteDto integranteTeste) {
        Assertions.assertEquals(resultado.getNome(), integranteTeste.nome());
        Assertions.assertEquals(resultado.getFuncao().toString(), integranteTeste.funcao().toString());
    }

    public static void validaIntegranteDtoMapper(IntegranteDto resultado, Integrante integranteTeste) {
        Assertions.assertEquals(resultado.nome(), integranteTeste.getNome());
        Assertions.assertEquals(resultado.funcao().toString(), integranteTeste.getFuncao().toString());
    }

    public static void validaIntegranteController(ResultActions resultado, Integrante comparacao) throws Exception {
        resultado.andExpect(jsonPath("$.dado.nome").value(comparacao.getNome()));
        resultado.andExpect(jsonPath("$.dado.funcao").value(comparacao.getFuncao().toString().trim()));
    }
}

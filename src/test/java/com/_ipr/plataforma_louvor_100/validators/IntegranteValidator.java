package com._ipr.plataforma_louvor_100.validators;

import com._ipr.plataforma_louvor_100.domain.Integrante;
import org.junit.jupiter.api.Assertions;

public class IntegranteValidator {

    public static void validaIntegranteDomain(Integrante resultado, Integrante integranteTeste) {
        Assertions.assertEquals(resultado.getNome(), integranteTeste.getNome());
        Assertions.assertEquals(resultado.getFuncao().toString(), integranteTeste.getFuncao().toString());
    }
}

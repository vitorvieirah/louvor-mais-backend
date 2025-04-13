package com._ipr.plataforma_louvor_100.validators;

import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import org.junit.jupiter.api.Assertions;

public class SetlistValidator {

    public static void validaSetlistDomainMapper(Setlist resultado, SetlistEntity comparacao) {
        Assertions.assertEquals(resultado.getData(), comparacao.getData());
        Assertions.assertEquals(resultado.getMusicas().size(), comparacao.getMusicas().size());
        Assertions.assertEquals(resultado.getFolgas().size(), comparacao.getFolgas().size());

        for (int i = 0; i < resultado.getMusicas().size(); i++) {
            MusicaValidator.validaMusicaDomainMapper(resultado.getMusicas().get(i), comparacao.getMusicas().get(i));
            IntegranteValidator.validaIntegranteDomainMapper(resultado.getFolgas().get(i), comparacao.getFolgas().get(i));
        }
    }

    public static void validaSetlistEntityMapper(SetlistEntity resultado, Setlist comparacao) {
        Assertions.assertEquals(resultado.getData(), comparacao.getData());
        Assertions.assertEquals(resultado.getMusicas().size(), comparacao.getMusicas().size());
        Assertions.assertEquals(resultado.getFolgas().size(), comparacao.getFolgas().size());

        for (int i = 0; i < resultado.getMusicas().size(); i++) {
            MusicaValidator.validaMusicaEntityMapper(resultado.getMusicas().get(i), comparacao.getMusicas().get(i));
            IntegranteValidator.validaIntegranteEntityMapper(resultado.getFolgas().get(i), comparacao.getFolgas().get(i));
        }
    }

    public static void validaSetlistDomain(Setlist resultado, Setlist comparacao) {
        Assertions.assertEquals(resultado.getData(), comparacao.getData());
        Assertions.assertEquals(resultado.getMusicas().size(), comparacao.getMusicas().size());
        Assertions.assertEquals(resultado.getFolgas().size(), comparacao.getFolgas().size());

        for (int i = 0; i < resultado.getMusicas().size(); i++) {
            MusicaValidator.validaMusicaDomain(resultado.getMusicas().get(i), comparacao.getMusicas().get(i));
            IntegranteValidator.validaIntegranteDomain(resultado.getFolgas().get(i), comparacao.getFolgas().get(i));
        }
    }
}

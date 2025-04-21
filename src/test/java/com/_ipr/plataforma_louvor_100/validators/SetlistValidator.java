package com._ipr.plataforma_louvor_100.validators;

import com._ipr.plataforma_louvor_100.domain.Setlist;
import com._ipr.plataforma_louvor_100.entrypoint.dto.SetlistDto;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.SetlistEntity;
import org.junit.jupiter.api.Assertions;
import org.springframework.data.domain.Page;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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

    public static void validaSetlistDomainMapper(Setlist resultado, SetlistDto comparacao) {
        Assertions.assertEquals(resultado.getData(), comparacao.data());
        Assertions.assertEquals(resultado.getMusicas().size(), comparacao.musicas().size());
        Assertions.assertEquals(resultado.getFolgas().size(), comparacao.folgas().size());

        for (int i = 0; i < resultado.getMusicas().size(); i++) {
            MusicaValidator.validaMusicaDomainMapper(resultado.getMusicas().get(i), comparacao.musicas().get(i));
            IntegranteValidator.validaIntegranteDomainMapper(resultado.getFolgas().get(i), comparacao.folgas().get(i));
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

    public static void validaSetlistDtoMapper(SetlistDto resultado, Setlist comparacao) {
        Assertions.assertEquals(resultado.data(), comparacao.getData());
        Assertions.assertEquals(resultado.musicas().size(), comparacao.getMusicas().size());
        Assertions.assertEquals(resultado.folgas().size(), comparacao.getFolgas().size());

        for (int i = 0; i < resultado.musicas().size(); i++) {
            MusicaValidator.validaMusicaDtoMapper(resultado.musicas().get(i), comparacao.getMusicas().get(i));
            IntegranteValidator.validaIntegranteDtoMapper(resultado.folgas().get(i), comparacao.getFolgas().get(i));
        }
    }

    public static void validaSetlistController(ResultActions resultado, Setlist comparacao) throws Exception {
        resultado.andExpect(jsonPath("$.dado.data").value(comparacao.getData()));

        String jsonPathBaseMusica = String.format("$.dado.musicas.content[%d].", 0);

        resultado.andExpect(jsonPath(jsonPathBaseMusica + "id_musica").value(comparacao.getMusicas().get(0).toString().trim()));
        resultado.andExpect(jsonPath(jsonPathBaseMusica + "nome").value(comparacao.getMusicas().get(0)));
        resultado.andExpect(jsonPath(jsonPathBaseMusica + "tom").value(comparacao.getMusicas().get(0).toString().trim()));
        resultado.andExpect(jsonPath(jsonPathBaseMusica + "versao").value(comparacao.getMusicas().get(0)));
        resultado.andExpect(jsonPath(jsonPathBaseMusica + "dificuldade").value(comparacao.getMusicas().get(0).toString().trim()));
        resultado.andExpect(jsonPath(jsonPathBaseMusica + "link").value(comparacao.getMusicas().get(0)));
        resultado.andExpect(jsonPath(jsonPathBaseMusica + "cifra").value(comparacao.getMusicas().get(0)));

        String jsonPathBaseIntegrante = String.format("$.dado.folgas.content[%d].", 0);

        resultado.andExpect(jsonPath(jsonPathBaseIntegrante + "nome").value(comparacao.getFolgas().get(0).getNome()));
        resultado.andExpect(jsonPath(jsonPathBaseIntegrante + "funcao").value(comparacao.getFolgas().get(0).getFuncao().toString().trim()));
    }

    public static void validaSetlistsController(ResultActions resultado, SetlistEntity comparacao, int indexList) throws Exception {
        String jsonPathBase = String.format("$.dado.content[%d].", indexList);

        resultado.andExpect(jsonPath(jsonPathBase + "data").value(comparacao.getData().toString().trim()));

        for (int i = 0; i < 2; i++) {
            String jsonPathBaseMusica = String.format("$.dado.musicas[%d].", i);

            resultado.andExpect(jsonPath(jsonPathBaseMusica + "id_musica").value(comparacao.getMusicas().get(i).toString().trim()));
            resultado.andExpect(jsonPath(jsonPathBaseMusica + "nome").value(comparacao.getMusicas().get(i)));
            resultado.andExpect(jsonPath(jsonPathBaseMusica + "tom").value(comparacao.getMusicas().get(i).toString().trim()));
            resultado.andExpect(jsonPath(jsonPathBaseMusica + "versao").value(comparacao.getMusicas().get(i)));
            resultado.andExpect(jsonPath(jsonPathBaseMusica + "dificuldade").value(comparacao.getMusicas().get(i).toString().trim()));
            resultado.andExpect(jsonPath(jsonPathBaseMusica + "link").value(comparacao.getMusicas().get(i)));
            resultado.andExpect(jsonPath(jsonPathBaseMusica + "cifra").value(comparacao.getMusicas().get(i)));
        }

        for (int i = 0; i < 3; i++) {
            String jsonPathBaseIntegrante = String.format("$.dado.folgas[%d].", i);

            resultado.andExpect(jsonPath(jsonPathBaseIntegrante + "nome").value(comparacao.getFolgas().get(i).getNome()));
            resultado.andExpect(jsonPath(jsonPathBaseIntegrante + "funcao").value(comparacao.getFolgas().get(i).getFuncao().toString().trim()));
        }

    }
}

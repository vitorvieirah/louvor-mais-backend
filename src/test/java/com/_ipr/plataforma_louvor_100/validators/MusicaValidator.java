package com._ipr.plataforma_louvor_100.validators;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class MusicaValidator {

    public static void validaMusicaDomain(Musica comparacao1, Musica comparacao2) {
        Assertions.assertEquals(comparacao1.getTom(), comparacao2.getTom());
        Assertions.assertEquals(comparacao1.getVersao(), comparacao2.getVersao());
        Assertions.assertEquals(comparacao1.getDificuldade(), comparacao2.getDificuldade());
        Assertions.assertEquals(comparacao1.getLink(), comparacao2.getLink());
        Assertions.assertEquals(comparacao1.getCifra(), comparacao2.getCifra());
    }

    public static void validaMusicaEntity(MusicaEntity comparacao1, MusicaEntity comparacao2) {
        Assertions.assertEquals(comparacao1.getIdMusica(), comparacao2.getIdMusica());
        Assertions.assertEquals(comparacao1.getTom(), comparacao2.getTom());
        Assertions.assertEquals(comparacao1.getVersao(), comparacao2.getVersao());
        Assertions.assertEquals(comparacao1.getDificuldade(), comparacao2.getDificuldade());
        Assertions.assertEquals(comparacao1.getLink(), comparacao2.getLink());
        Assertions.assertEquals(comparacao1.getCifra(), comparacao2.getCifra());
    }

    public static void validaMusicaDto(MusicaDto comparacao1, MusicaDto comparacao2) {
        Assertions.assertEquals(comparacao1.idMusica(), comparacao2.idMusica());
        Assertions.assertEquals(comparacao1.tom(), comparacao2.tom());
        Assertions.assertEquals(comparacao1.versao(), comparacao2.versao());
        Assertions.assertEquals(comparacao1.dificuldade(), comparacao2.dificuldade());
        Assertions.assertEquals(comparacao1.link(), comparacao2.link());
        Assertions.assertEquals(comparacao1.cifra(), comparacao2.cifra());
    }

    public static void validaMusicaDomainMapper(Musica comparacao1, MusicaEntity comparacao2) {
        Assertions.assertEquals(comparacao1.getIdMusica(), comparacao2.getIdMusica());
        Assertions.assertEquals(comparacao1.getTom(), comparacao2.getTom());
        Assertions.assertEquals(comparacao1.getVersao(), comparacao2.getVersao());
        Assertions.assertEquals(comparacao1.getDificuldade(), comparacao2.getDificuldade());
        Assertions.assertEquals(comparacao1.getLink(), comparacao2.getLink());
        Assertions.assertEquals(comparacao1.getCifra(), comparacao2.getCifra());
    }

    public static void validaMusicaEntityMapper(MusicaEntity comparacao1, Musica comparacao2) {
        Assertions.assertEquals(comparacao1.getIdMusica(), comparacao2.getIdMusica());
        Assertions.assertEquals(comparacao1.getTom(), comparacao2.getTom());
        Assertions.assertEquals(comparacao1.getVersao(), comparacao2.getVersao());
        Assertions.assertEquals(comparacao1.getDificuldade(), comparacao2.getDificuldade());
        Assertions.assertEquals(comparacao1.getLink(), comparacao2.getLink());
        Assertions.assertEquals(comparacao1.getCifra(), comparacao2.getCifra());
    }

    public static void validaMusicaController(ResultActions resultado, Musica comparacao) throws Exception {
        resultado.andExpect(jsonPath("$.dado.nome").value(comparacao.getNome()));
        resultado.andExpect(jsonPath("$.dado.tom").value(comparacao.getTom().toString().trim()));
        resultado.andExpect(jsonPath("$.dado.versao").value(comparacao.getVersao()));
        resultado.andExpect(jsonPath("$.dado.dificuldade").value(comparacao.getDificuldade().toString().trim()));
        resultado.andExpect(jsonPath("$.dado.link").value(comparacao.getLink()));
        resultado.andExpect(jsonPath("$.dado.cifra").value(comparacao.getCifra()));
    }

    public static void validaMusicasController(ResultActions resultado, int indexProdutoList, MusicaEntity comparacao) throws Exception {
        String jsonPathBase = String.format("$.dado.content[%d].", indexProdutoList);

        resultado.andExpect(jsonPath(jsonPathBase + "id_musica").value(comparacao.getIdMusica().toString().trim()));
        resultado.andExpect(jsonPath(jsonPathBase + "nome").value(comparacao.getNome()));
        resultado.andExpect(jsonPath(jsonPathBase + "tom").value(comparacao.getTom().toString().trim()));
        resultado.andExpect(jsonPath(jsonPathBase + "versao").value(comparacao.getVersao()));
        resultado.andExpect(jsonPath(jsonPathBase + "dificuldade").value(comparacao.getDificuldade().toString().trim()));
        resultado.andExpect(jsonPath(jsonPathBase + "link").value(comparacao.getLink()));
        resultado.andExpect(jsonPath(jsonPathBase + "cifra").value(comparacao.getCifra()));
    }
}

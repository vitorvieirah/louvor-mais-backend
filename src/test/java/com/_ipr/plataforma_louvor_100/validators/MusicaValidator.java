package com._ipr.plataforma_louvor_100.validators;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.entrypoint.dto.MusicaDto;
import com._ipr.plataforma_louvor_100.infrastructure.repositories.entities.musica.MusicaEntity;
import org.junit.jupiter.api.Assertions;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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

    /*@JsonProperty("id_musica")
        UUID idMusica,

        @NotBlank(message = "O nome é obrigatório")
        @JsonProperty("nome")
        String nome,

        @JsonProperty("tom")
        TomMusica tom,

        @JsonProperty("versao")
        String versao,

        @JsonProperty("dificuldade")
        DificuldadeMusica dificuldade,

        @NotBlank(message = "O link da música é obrigatório")
        @JsonProperty("link")
        String link,

        @JsonProperty("cifra")
        String cifra)
     */

    public static void validaMusicaController(ResultActions resultado, Musica comparacao) throws Exception {
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.nome").value(comparacao.getNome()));
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.tom").value(comparacao.getTom()));
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.versao").value(comparacao.getVersao()));
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.dificuldade").value(comparacao.getDificuldade()));
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.link").value(comparacao.getLink()));
        resultado.andExpect(MockMvcResultMatchers.jsonPath("$.dado.cifra").value(comparacao.getCifra()));
    }
}

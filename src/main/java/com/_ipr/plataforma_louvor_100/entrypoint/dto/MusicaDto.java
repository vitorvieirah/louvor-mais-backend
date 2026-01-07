package com._ipr.plataforma_louvor_100.entrypoint.dto;

import com._ipr.plataforma_louvor_100.domain.musica.Clima;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.UUID;

@Builder
public record MusicaDto(

        @JsonProperty("id_musica")
        UUID idMusica,

        @NotBlank(message = "O nome é obrigatório")
        @JsonProperty("nome")
        String nome,

        @JsonProperty("artista")
        String artista,

        @JsonProperty("tom")
        TomMusica tom,

        @JsonProperty("decricao_tom")
        String descricaoTom,

        @JsonProperty("clima")
        Clima clima,

        @JsonProperty("descricao_clima")
        String descricaoClima,

        @JsonProperty("bpm")
        Integer bpm,

        @JsonProperty("compositor")
        String compositor,

        @NotBlank(message = "O link da música é obrigatório")
        @JsonProperty("link")
        String link,

        @JsonProperty("cifra")
        String cifra)
{}

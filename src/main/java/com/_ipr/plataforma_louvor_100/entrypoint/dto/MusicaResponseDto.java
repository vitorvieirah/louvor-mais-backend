package com._ipr.plataforma_louvor_100.entrypoint.dto;

import com._ipr.plataforma_louvor_100.domain.musica.DificuldadeMusica;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.UUID;

@Builder
public record MusicaResponseDto(
        @JsonProperty("id_musica")
        UUID idMusica,

        @NotBlank(message = "O nome é obrigatório")
        @JsonProperty("nome")
        String nome,

        @JsonProperty("tom")
        String tom,

        @JsonProperty("versao")
        String versao,

        @JsonProperty("dificuldade")
        String dificuldade,

        @NotBlank(message = "O link da música é obrigatório")
        @JsonProperty("link")
        String link,

        @JsonProperty("cifra")
        String cifra
) {}

package com._ipr.plataforma_louvor_100.entrypoint.dto;

import com._ipr.plataforma_louvor_100.domain.FuncaoIntegrante;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.UUID;

@Builder
public record IntegranteDto(
        @JsonProperty("id_integrante")
        UUID idIntegrante,

        @NotBlank
        @JsonProperty("nome")
        String nome,

        @NotBlank
        @JsonProperty("funcao")
        FuncaoIntegrante funcao
) {}

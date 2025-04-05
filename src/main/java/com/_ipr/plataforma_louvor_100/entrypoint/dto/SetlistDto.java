package com._ipr.plataforma_louvor_100.entrypoint.dto;

import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
public record SetlistDto (

        @JsonProperty("id_setlist")
        UUID idSetlist,

        @NotBlank(message = "A data é obrigatória.")
        @JsonProperty("data")
        LocalDate data,

        @NotBlank(message = "É obrigatório ter pelomenos uma música.")
        @JsonProperty("musicas")
        List<MusicaDto>musicas,

        @JsonProperty("folgas")
        List<IntegranteDto> folgas

){}

package com._ipr.plataforma_louvor_100.entrypoint.dto;

import com._ipr.plataforma_louvor_100.domain.Integrante;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
public record SetlistDto (UUID idSetlist, LocalDate data, List<Musica>musicas, List<Integrante> folgas){}

package com._ipr.plataforma_louvor_100.domain;

import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Setlist {
    private UUID idSetlist;
    private LocalDate data;
    private List<Musica> musicas;
    private List<Integrante> folgas;
}

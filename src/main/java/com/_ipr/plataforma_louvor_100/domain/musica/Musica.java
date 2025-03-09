package com._ipr.plataforma_louvor_100.domain.musica;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Musica {
    private UUID idMusica;
    private String nome;
    private TomMusica tom;
    private String versao;
    private DificuldadeMusica dificuldade;
    private String link;
    private String cifra;
}

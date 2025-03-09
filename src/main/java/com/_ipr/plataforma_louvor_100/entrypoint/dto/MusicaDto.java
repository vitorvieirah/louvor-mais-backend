package com._ipr.plataforma_louvor_100.entrypoint.dto;

import com._ipr.plataforma_louvor_100.domain.musica.DificuldadeMusica;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;
import lombok.Builder;

import java.util.UUID;

@Builder
public record MusicaDto(UUID idMusica, String nome, TomMusica tom, String versao, DificuldadeMusica dificuldade, String link, String cifra) {
}

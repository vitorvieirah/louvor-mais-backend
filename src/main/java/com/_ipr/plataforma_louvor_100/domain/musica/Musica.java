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
    private String artista;
    private TomMusica tom;
    private Clima clima;
    private Integer bpm;
    private String compositor;
    private String link;
    private String cifra;

    public void setDados(Musica novosDados) {
        this.nome = novosDados.getNome();
        this.artista = novosDados.getArtista();
        this.tom = novosDados.getTom();
        this.clima = novosDados.getClima();
        this.bpm = novosDados.getBpm();
        this.compositor = novosDados.getCompositor();
        this.link = novosDados.getLink();
        this.cifra = novosDados.getCifra();
    }
}

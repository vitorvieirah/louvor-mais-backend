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

    public void setDados(Musica novosDados) {
        this.nome = novosDados.getNome();
        this.tom = novosDados.getTom();
        this.versao = novosDados.getVersao();
        this.dificuldade = novosDados.getDificuldade();
        this.link = novosDados.getLink();
        this.cifra = novosDados.getCifra();
    }
}

package com._ipr.plataforma_louvor_100.builder;

import com._ipr.plataforma_louvor_100.domain.musica.DificuldadeMusica;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import com._ipr.plataforma_louvor_100.domain.musica.TomMusica;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MusicaBuilder {

    public static Musica gerarMusica() {
        return Musica.builder()
                .idMusica(UUID.fromString("3544fce4-b2d5-497b-8f77-dda4fcd9e0fd"))
                .nome("Musica teste")
                .tom(TomMusica.D)
                .cifra("linkcifrateste")
                .dificuldade(DificuldadeMusica.FACIL)
                .link("linkdamusica")
                .versao("Versão teste")
                .build();

    }

    public static List<Musica> gerarListaMusica() {
        List<Musica> musicas = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            musicas.add(gerarMusica());
        }

        return musicas;
    }
}

package com._ipr.plataforma_louvor_100.validators;

import com._ipr.plataforma_louvor_100.builder.MusicaBuilder;
import com._ipr.plataforma_louvor_100.domain.musica.Musica;
import org.junit.jupiter.api.Assertions;

public class MusicaValidator {

    public static void validaMusica(Musica musicaTeste) {
        Assertions.assertEquals(musicaTeste.getIdMusica(), MusicaBuilder.gerarMusica().getIdMusica());
        Assertions.assertEquals(musicaTeste.getTom(), MusicaBuilder.gerarMusica().getTom());
        Assertions.assertEquals(musicaTeste.getVersao(), MusicaBuilder.gerarMusica().getVersao());
        Assertions.assertEquals(musicaTeste.getDificuldade(), MusicaBuilder.gerarMusica().getDificuldade());
        Assertions.assertEquals(musicaTeste.getLink(), MusicaBuilder.gerarMusica().getLink());
        Assertions.assertEquals(musicaTeste.getCifra(), MusicaBuilder.gerarMusica().getCifra());
    }
}

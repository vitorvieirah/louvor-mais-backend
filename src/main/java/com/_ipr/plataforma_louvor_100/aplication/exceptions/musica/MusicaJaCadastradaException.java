package com._ipr.plataforma_louvor_100.aplication.exceptions.musica;

public class MusicaJaCadastradaException extends RuntimeException {
    public MusicaJaCadastradaException() {
        super("Música já cadastrada com esse nome.");
    }
}

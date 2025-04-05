package com._ipr.plataforma_louvor_100.aplication.exceptions.musica;

public class MusicaNaoEncontradaException extends RuntimeException {
    public MusicaNaoEncontradaException() {
        super("Música não encontrada com esse id.");
    }
}

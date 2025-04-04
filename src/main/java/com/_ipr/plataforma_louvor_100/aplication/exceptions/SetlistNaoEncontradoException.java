package com._ipr.plataforma_louvor_100.aplication.exceptions;

public class SetlistNaoEncontradoException extends RuntimeException {

    public SetlistNaoEncontradoException() {
        super("Setlist não encontrado com esse id.");
    }
}

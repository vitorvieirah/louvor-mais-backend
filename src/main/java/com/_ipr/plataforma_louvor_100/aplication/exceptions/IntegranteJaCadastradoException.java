package com._ipr.plataforma_louvor_100.aplication.exceptions;

public class IntegranteJaCadastradoException extends RuntimeException {
    public IntegranteJaCadastradoException() {
        super("Integrante já cadastrado com esse nome.");
    }
}

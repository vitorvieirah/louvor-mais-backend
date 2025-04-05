package com._ipr.plataforma_louvor_100.aplication.exceptions.integrante;

public class IntegranteNaoEncontradoException extends RuntimeException {

    public IntegranteNaoEncontradoException() {
        super("Integrante não encontrado pelo seu id.");
    }
}

package com._ipr.plataforma_louvor_100.infrastructure.dataprovider.exceptions;

public class DataProviderException extends RuntimeException {
    public DataProviderException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

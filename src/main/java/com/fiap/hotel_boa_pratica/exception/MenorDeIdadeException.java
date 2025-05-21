package com.fiap.hotel_boa_pratica.exception;

public class MenorDeIdadeException extends RuntimeException {

    public MenorDeIdadeException() {
        super("Não aceitamos menor de idade.");
    }

}

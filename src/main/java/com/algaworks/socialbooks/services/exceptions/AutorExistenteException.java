package com.algaworks.socialbooks.services.exceptions;

public class AutorExistenteException extends RuntimeException{

    public AutorExistenteException(String mensagem) {
        super(mensagem);
    }

    public AutorExistenteException(String message, Throwable cause) {
        super(message, cause);
    }
}

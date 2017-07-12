package com.algaworks.socialbooks.services.exceptions;

public class AutorNaoEncontradoException extends RuntimeException{

    public AutorNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public AutorNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}

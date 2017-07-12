package com.algaworks.socialbooks.services.exceptions;

public class LivroNaoEncontradoException extends RuntimeException{

    public LivroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public LivroNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}

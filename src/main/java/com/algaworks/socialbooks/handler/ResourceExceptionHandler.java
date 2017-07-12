package com.algaworks.socialbooks.handler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(LivroNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleLivroNaoEncontradoException(LivroNaoEncontradoException e, HttpServletRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro();
        detalhesErro.setStatus(404L);
        detalhesErro.setTitulo("O livro não pôde ser encontrado");
        detalhesErro.setMensagemDesenvolvedor("http://errors.socialbooks.com/404");
        detalhesErro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
    }
}

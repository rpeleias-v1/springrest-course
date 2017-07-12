package com.algaworks.socialbooks.handler;

import com.algaworks.socialbooks.domain.DetalhesErro;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler(AutorExistenteException.class)
    public ResponseEntity<DetalhesErro> handleAutorExistenteException(AutorExistenteException e, HttpServletRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro();
        detalhesErro.setStatus(409L);
        detalhesErro.setTitulo("O autor já existe");
        detalhesErro.setMensagemDesenvolvedor("http://errors.socialbooks.com/409");
        detalhesErro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(detalhesErro);
    }

    @ExceptionHandler(AutorNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleAutorNaoEncontradoException(AutorNaoEncontradoException e, HttpServletRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro();
        detalhesErro.setStatus(404L);
        detalhesErro.setTitulo("O autor não pôde ser encontrado");
        detalhesErro.setMensagemDesenvolvedor("http://errors.socialbooks.com/404");
        detalhesErro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(detalhesErro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        DetalhesErro detalhesErro = new DetalhesErro();
        detalhesErro.setStatus(400L);
        detalhesErro.setTitulo("Requisição inválida");
        detalhesErro.setMensagemDesenvolvedor("http://errors.socialbooks.com/404");
        detalhesErro.setTimestamp(System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(detalhesErro);
    }
}

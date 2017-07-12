package com.algaworks.socialbooks.services;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;
import com.algaworks.socialbooks.services.exceptions.LivroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {

    @Autowired
    private LivrosRepository livrosRepository;

    public List<Livro> listar() {
        return livrosRepository.findAll();
    }

    public Livro salvar(Livro livro) {
        livro.setId(null);
        return livrosRepository.save(livro);
    }

    public Livro buscar(Long aLong) {
        Livro livro = livrosRepository.findOne(aLong);
        if (livro == null) {
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado");
        }
        return livro;
    }

    public void deletar(Long id) {
        try {
            livrosRepository.delete(id);
        } catch (EmptyResultDataAccessException e) {
            throw new LivroNaoEncontradoException("O livro não pôde ser encontrado");
        }
    }

    public void atualizar(Livro livro) {
        buscar(livro.getId());
        livrosRepository.save(livro);
    }
}

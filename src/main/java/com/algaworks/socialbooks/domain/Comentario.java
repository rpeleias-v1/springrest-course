package com.algaworks.socialbooks.domain;

import java.util.Date;

public class Comentario {

    private Long id;
    private String teto;
    private String usuario;
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeto() {
        return teto;
    }

    public void setTeto(String teto) {
        this.teto = teto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}

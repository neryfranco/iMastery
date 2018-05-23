package com.neryfranco.masterygame.model;

/**
 * Created by Nery on 13/05/2018.
 */

public class TipoConteudo {

    private Integer id;
    private String tipo;

    public TipoConteudo(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}

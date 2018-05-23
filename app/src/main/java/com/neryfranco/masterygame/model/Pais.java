package com.neryfranco.masterygame.model;

/**
 * Created by Nery on 13/05/2018.
 */
public class Pais {

    private Integer id;
    private String nomePais;

    public Pais(Integer id, String nomePais) {
        this.id = id;
        this.nomePais = nomePais;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }
}

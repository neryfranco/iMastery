package com.neryfranco.masterygame.model;

/**
 * Created by Nery on 13/05/2018.
 */

public class Habilidade {

    private Integer id;
    private String nome;

    public Habilidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

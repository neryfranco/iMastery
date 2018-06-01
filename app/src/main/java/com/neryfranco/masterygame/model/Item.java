package com.neryfranco.masterygame.model;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by Nery on 13/05/2018.
 */

public class Item implements Serializable{

    private Integer id;
    private String titulo;
    private String descricao;
    private Double points;
    private Double cash;
    private Integer validade;
    private Image imagem;

    public Item(Integer id, String titulo, String descricao, Double points, Double cash, Integer validade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.points = points;
        this.cash = cash;
        this.validade = validade;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public Integer getValidade() {
        return validade;
    }

    public void setValidade(Integer validade) {
        this.validade = validade;
    }
}

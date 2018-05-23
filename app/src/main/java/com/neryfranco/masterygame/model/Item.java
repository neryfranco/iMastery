package com.neryfranco.masterygame.model;

/**
 * Created by Nery on 13/05/2018.
 */

public class Item {

    private Integer id;
    private String titulo;
    private String descricao;
    private Double points;
    private Double gold;

    public Item(Integer id, String titulo, Double points) {
        this.id = id;
        this.titulo = titulo;
        this.points = points;
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

    public Double getGold() {
        return gold;
    }

    public void setGold(Double gold) {
        this.gold = gold;
    }
}

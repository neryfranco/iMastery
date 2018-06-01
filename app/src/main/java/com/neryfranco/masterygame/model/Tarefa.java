package com.neryfranco.masterygame.model;

import java.io.Serializable;

public class Tarefa implements Serializable{

    private Integer id;
    private String titulo;
    private String descricao;
    private Integer reputacao;
    private Double exp;
    private Double points;
    private Integer level;
    private Aula aula;
    private Matricula matricula;

    public Tarefa(Integer id, String titulo, String descricao, Integer reputacao, Double exp, Double points, Integer level, Aula aula, Matricula matricula) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.reputacao = reputacao;
        this.exp = exp;
        this.points = points;
        this.level = level;
        this.aula = aula;
        this.matricula = matricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getReputacao() {
        return reputacao;
    }

    public void setReputacao(int reputacao) {
        this.reputacao = reputacao;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getPoints() {return points;}

    public void setPoints(double points) {
        this.points = points;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

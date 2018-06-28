package com.neryfranco.masterygame.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Tarefa implements Serializable{

    private Integer id;
    private String titulo;
    private String descricao;
    private Integer reputacao;
    private Double exp;
    private Double points;
    private Aula aula;
    private Professor professor;
    private Aluno aluno;
    private static final AtomicInteger count = new AtomicInteger(0);

    public Tarefa(String titulo, String descricao, Double exp, Double points, Aula aula, Professor professor) {
        this.id = count.incrementAndGet();
        this.titulo = titulo;
        this.descricao = descricao;
        this.exp = exp;
        this.points = points;
        this.aula = aula;
        this.professor = professor;
        this.reputacao = 0;
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

    public Double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getPoints() {return points;}

    public void setPoints(double points) {
        this.points = points;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}

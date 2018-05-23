package com.neryfranco.masterygame.model;

/**
 * Created by Nery on 13/05/2018.
 */

public class Matricula {

    private Professor professor;
    private Integer id;
    private Aluno aluno;
    private Integer status;
    private Integer level;
    private Double exp;
    private Double points;

    public Matricula(Professor professor, Integer id, Aluno aluno) {
        this.professor = professor;
        this.id = id;
        this.aluno = aluno;
        status = 1;
        level = 0;
        exp = 0.0;
        points = 0.0;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getExp() {
        return exp;
    }

    public void setExp(Double exp) {
        this.exp = exp;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
}

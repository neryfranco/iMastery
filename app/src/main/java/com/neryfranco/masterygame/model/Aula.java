package com.neryfranco.masterygame.model;

import java.util.List;

/**
 * Created by Nery on 13/05/2018.
 */

public class Aula {

    private Professor professor;
    private Integer id;
    private String titulo;
    private String descricao;
    private Aula pre_requisito;
    private List<Habilidade> habilidades;
    private List<Conteudo> conteudos;

    public Aula(Professor professor, Integer id, String titulo, String descricao, Aula pre_requisito) {
        this.professor = professor;
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pre_requisito = pre_requisito;
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

    public Aula getPre_requisito() {
        return pre_requisito;
    }

    public void setPre_requisito(Aula pre_requisito) {
        this.pre_requisito = pre_requisito;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(List<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
}

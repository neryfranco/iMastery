package com.neryfranco.masterygame.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Nery on 13/05/2018.
 */

public class Aula implements Serializable{

    private Professor professor;
    private Integer id;
    private String titulo;
    private String descricao;
    private ArrayList<Aula> pre_requisito;
    private ArrayList<Habilidade> habilidades;
    private ArrayList<Conteudo> conteudos;
    private static final AtomicInteger count = new AtomicInteger(0);

    public Aula(Professor professor, String titulo, String descricao, ArrayList<Aula> pre_requisito) {
        this.id = count.incrementAndGet();
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

    public ArrayList<Aula> getPre_requisito() {
        return pre_requisito;
    }

    public void setPre_requisito(ArrayList<Aula> pre_requisito) {
        this.pre_requisito = pre_requisito;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Conteudo> getConteudos() {
        return conteudos;
    }

    public void setConteudos(ArrayList<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
}

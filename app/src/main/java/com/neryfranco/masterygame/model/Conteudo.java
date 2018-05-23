package com.neryfranco.masterygame.model;

import java.io.File;

/**
 * Created by Nery on 13/05/2018.
 */

public class Conteudo {

    private Professor professor;
    private Integer id;
    private String nome;
    private String descricao;
    private String link;
    private File arquivo;
    private TipoConteudo tipo;

    public Conteudo(Professor professor, Integer id, String nome, String descricao, String link, File arquivo, TipoConteudo tipo) {
        this.professor = professor;
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
        this.arquivo = arquivo;
        this.tipo = tipo;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

    public TipoConteudo getTipo() {
        return tipo;
    }

    public void setTipo(TipoConteudo tipo) {
        this.tipo = tipo;
    }
}

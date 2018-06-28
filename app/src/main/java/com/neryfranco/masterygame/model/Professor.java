package com.neryfranco.masterygame.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Nery on 13/05/2018.
 */

public class Professor extends Usuario implements Serializable{

    private Integer id;
    private Date inicio_carreira;
    private Integer num_alunos_atuais;
    private Integer num_alunos_total;
    private Integer num_max_alunos;
    private Double exp;
    private ArrayList<Item> itens;
    private ArrayList<Aluno> alunos;
    private ArrayList<Aula> aulas;

    public Professor(String email, String senha, String nome_completo, String nick, Integer num_max_alunos) {
        super(email, senha, nome_completo, nick);
        this.num_alunos_atuais = 0;
        this.num_alunos_total = 0;
        this.num_max_alunos = num_max_alunos;
        this.exp = 0.0;
        this.itens = new ArrayList<>();
        this.alunos = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio_carreira() {
        return inicio_carreira;
    }

    public void setInicio_carreira(Date inicio_carreira) {
        this.inicio_carreira = inicio_carreira;
    }

    public Integer getNum_alunos_atuais() {
        return num_alunos_atuais;
    }

    public void setNum_alunos_atuais(Integer num_alunos_atuais) {
        this.num_alunos_atuais = num_alunos_atuais;
    }

    public Integer getNum_alunos_total() {
        return num_alunos_total;
    }

    public void setNum_alunos_total(Integer num_alunos_total) {
        this.num_alunos_total = num_alunos_total;
    }

    public Double getExp() {
        return exp;
    }

    public void setExp(Double exp) {
        this.exp = exp;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Integer getNum_max_alunos() {
        return num_max_alunos;
    }

    public void setNum_max_alunos(Integer num_max_alunos) {
        this.num_max_alunos = num_max_alunos;
    }

    public void addAluno(Aluno aluno){
        alunos.add(aluno);
        this.num_alunos_atuais++;
        this.num_alunos_total++;
    }

    public void removeAluno(){
        this.num_alunos_atuais--;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }
}

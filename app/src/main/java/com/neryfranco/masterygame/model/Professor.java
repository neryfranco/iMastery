package com.neryfranco.masterygame.model;

import java.util.Date;
import java.util.List;

/**
 * Created by Nery on 13/05/2018.
 */

public class Professor extends Usuario {

    private Integer id;
    private Date inicio_carreira;
    private Integer num_alunos_atuais;
    private Integer num_alunos_total;
    private Double exp;
    private List<Item> itens;

    public Professor(String email, String senha, String nome_completo, String nick) {
        super(email, senha, nome_completo, nick);
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

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}

package com.neryfranco.masterygame.model;

import java.util.List;

/**
 * Created by Nery on 13/05/2018.
 */

public class Aluno extends Usuario {

    private Integer level;
    private Double exp;
    private Double gold;
    private List<Item> itens;

    public Aluno(String email, String senha, String nome_completo, String nick) {
        super(email, senha, nome_completo, nick);
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

    public Double getGold() {
        return gold;
    }

    public void setGold(Double gold) {
        this.gold = gold;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}

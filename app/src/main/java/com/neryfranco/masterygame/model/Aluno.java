package com.neryfranco.masterygame.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nery on 13/05/2018.
 */

public class Aluno extends Usuario implements Serializable{

    private Integer level;
    private Double exp;
    private Double cash;
    private ArrayList<Item> itens;
    private Matricula matricula;
    private ArrayList<Horario> horarios;
    private ArrayList<Tarefa> tarefasConcluidas;

    public Aluno(String email, String senha, String nome_completo, String nick) {
        super(email, senha, nome_completo, nick);
        exp = 0.0;
        cash = 0.0;
        level = 0;
        matricula = null;
        horarios = new ArrayList<>();
        tarefasConcluidas = new ArrayList<>();
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

    public void addExp(Double exp){
        this.exp += exp;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<Horario> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<Tarefa> getTarefasConcluidas() {
        return tarefasConcluidas;
    }

    public void setTarefasConcluidas(ArrayList<Tarefa> tarefasConcluidas) {
        this.tarefasConcluidas = tarefasConcluidas;
    }

    public void addTarefaConcluida(Tarefa tarefa){
        tarefasConcluidas.add(tarefa);
    }
}

package com.neryfranco.masterygame.model;

import java.io.Serializable;
import java.sql.Time;

public class Horario implements Serializable{

    private int id;
    private Time horario;
    private int diaSemana;

    public Horario(Time horario, int diaSemana) {
        this.horario = horario;
        this.diaSemana = diaSemana;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDiaHora(){
        String dia;
        switch (diaSemana) {
            case 1:
                dia = "Domingo";
                break;
            case 2:
                dia = "Segunda";
                break;
            case 3:
                dia = "Terça";
                break;
            case 4:
                dia = "Quarta";
                break;
            case 5:
                dia = "Quinta";
                break;
            case 6:
                dia = "Sexta";
                break;
            case 7:
                dia = "Sábado";
                break;
            default:
                dia = "Sábado";
        }
        String hora = horario.toString().substring(0,5);
        return dia + " - " + hora;
    }
}

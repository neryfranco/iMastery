package com.neryfranco.masterygame;

import android.os.Bundle;

import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Matricula;
import com.neryfranco.masterygame.model.Professor;
import com.neryfranco.masterygame.model.Tarefa;

import java.util.ArrayList;

public class ProfessorBundle {

    private static Bundle bundle;
    private static ArrayList<Matricula> matriculas;
    private static Professor professor;
    private static ArrayList<Item> itens;

    public static void setDefault(){
        professor = new Professor("contato@neryfranco.com","321","Mateus Nery Franco", "neryfranco", 10);
        matriculas = new ArrayList<>();
        itens = new ArrayList<>();
    }

    public static Bundle getBundle(){
        return bundle;
    }

    public static void setBundle(Bundle bundle) {
        ProfessorBundle.bundle = bundle;
    }

    public static Professor getProfessor() {
        return professor;
    }

    public static void setProfessor(Professor professor) {
        ProfessorBundle.professor = professor;
    }

    public static ArrayList<Item> getItens() {
        return itens;
    }

    public static void setItens(ArrayList<Item> itens) {
        ProfessorBundle.itens = itens;
    }
}

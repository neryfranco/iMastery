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
    private static ArrayList<Aluno> alunos;

    public static void setDefault(){
        professor = new Professor("contato@neryfranco.com","321","Mateus Nery Franco", "neryfranco", 10);
        matriculas = new ArrayList<>();
        itens = new ArrayList<>();
        alunos = new ArrayList<>();
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

    public static ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public static void setMatriculas(ArrayList<Matricula> matriculas) {
        ProfessorBundle.matriculas = matriculas;
    }

    public static ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public static void setAlunos(ArrayList<Aluno> alunos) {
        ProfessorBundle.alunos = alunos;
    }

    public static void addAluno(Aluno aluno){
        alunos.add(aluno);
        professor.addAluno(aluno);
    }

    public static void removeAluno(Aluno aluno){
        for(int i = 0; i < alunos.size(); i++){
            if(aluno.getEmail() == alunos.get(i).getEmail()){
                alunos.remove(i);
                professor.setAlunos(alunos);
            }
        }
    }
}

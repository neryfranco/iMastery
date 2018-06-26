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
        itens = adicionarItens();
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

    private static ArrayList<Item> adicionarItens() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item e = new Item("10% de Desconto", "Desconto de 10% na próxima mensalidade.",500.0, null, 10);
        items.add(e);

        e = new Item("Exercícios Técnicos", "Pacote com 5 exercícios técnicos abordando " +
                "os assuntos de sua escolha",300.0, 40.0, 30);
        items.add(e);

        e = new Item("Tutorial Musical - Harmonia", "Uma vídeo aula explicando a harmonia" +
                " de uma música de seu interesse.",800.0, 50.0, 30);
        items.add(e);

        e = new Item("Tutorial Musical - Técnica", "Uma vídeo aula ensinando as técnicas" +
                "contidas em uma música de seu interesse.",900.0, 60.0, 30);
        items.add(e);

        return items;

    }
}

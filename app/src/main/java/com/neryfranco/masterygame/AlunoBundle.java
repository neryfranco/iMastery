package com.neryfranco.masterygame;
import android.os.Bundle;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Matricula;
import com.neryfranco.masterygame.model.Professor;
import com.neryfranco.masterygame.model.Tarefa;
import java.util.ArrayList;

public class AlunoBundle {

    private static Bundle bundle;
    private static Matricula matricula;
    private static Aluno aluno;
    private static Professor professor;
    private static ArrayList<Tarefa> tarefas;
    private static ArrayList<Item> itens;
    private static boolean matriculado;

    public static void newAccount(){
        professor = new Professor("contato@neryfranco.com","321","Mateus Nery Franco", "neryfranco", 10);
        matricula = null;
        matriculado = false;
        tarefas = new ArrayList<>();
        itens = new ArrayList<>();
    }

    public static void setDefault(){
        aluno = new Aluno("email@email.com", "123", "Aluno A", "aluno_example");
        newAccount();
    }

    public static Bundle getBundle(){
        return bundle;
    }

    public static void setBundle(Bundle bundle) {
        AlunoBundle.bundle = bundle;
    }

    public static Matricula getMatricula() {
        return matricula;
    }

    public static void setMatricula(Matricula m){
        matricula = m;
    }

    public static void newMatricula(Matricula m) {
        matricula = m;
        aluno.setMatricula(matricula);
        professor.addAluno(aluno);
        matriculado = true;
    }

    public static void removeMatricula(){
        matricula = null;
        aluno.setMatricula(null);
        professor.removeAluno(aluno);
        matriculado = false;
    }

    public static Aluno getAluno() {
        return aluno;
    }

    public static void setAluno(Aluno aluno) {
        AlunoBundle.aluno = aluno;
    }

    public static Professor getProfessor() {
        return professor;
    }

    public static void setProfessor(Professor professor) {
        AlunoBundle.professor = professor;
    }

    public static void setMatriculado(boolean matriculado) {
        AlunoBundle.matriculado = matriculado;
    }

    public static boolean isMatriculado(){
        return matriculado;
    }

    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }

    public static void setTarefas(ArrayList<Tarefa> tarefas) {
        AlunoBundle.tarefas = tarefas;
    }

    public static void addTarefa(Tarefa tarefa){
        tarefas.add(tarefa);
        matricula.addTarefa(tarefa);
    }

    public static ArrayList<Item> getItens() {
        return itens;
    }

    public static void setItens(ArrayList<Item> itens) {
        AlunoBundle.itens = itens;
    }
}

package com.neryfranco.masterygame;
import android.content.Intent;
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
    private static ArrayList<Tarefa> tarefas;
    private static ArrayList<Item> itens;
    private static boolean matriculado;

    public static void newAccount(){

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
        matriculado = true;
    }

    public static void removeMatricula(){
        matricula = null;
        aluno.setMatricula(null);
        matriculado = false;
    }

    public static Aluno getAluno() {
        return aluno;
    }

    public static void setAluno(Aluno aluno) {
        AlunoBundle.aluno = aluno;
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
        matricula.setTarefas(tarefas);
    }

    public static void removeTarefa(Tarefa tarefa){
        for(int i = 0; i < tarefas.size(); i++){
            if(tarefa.getId() == tarefas.get(i).getId()){
                tarefas.remove(i);
                matricula.setTarefas(tarefas);
            }
        }
    }

    public static ArrayList<Item> getItens() {
        return itens;
    }

    public static void setItens(ArrayList<Item> itens) {
        AlunoBundle.itens = itens;
    }

    public static void addItem(Item item){
        aluno.addItem(item);
        itens = aluno.getItens();
    }

    public static boolean containItem(Item item){
        itens = aluno.getItens();
        for(int i = 0; i < itens.size(); i++){
            if(item.getId() == itens.get(i).getId()){
                return true;
            }
        }
        return false;
    }
}

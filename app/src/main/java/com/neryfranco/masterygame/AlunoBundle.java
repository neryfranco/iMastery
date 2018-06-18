package com.neryfranco.masterygame;

import android.content.Intent;
import android.os.Bundle;

import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Matricula;
import com.neryfranco.masterygame.model.Professor;

public class AlunoBundle {

    private static Bundle bundle;
    private static Matricula matricula;
    private static Aluno aluno;
    private static Professor professor;

    public static void setDefault(){
        aluno = new Aluno("email@email.com", "123", "Aluno A", "aluno_example");
        professor = new Professor("contato@neryfranco.com","321","Mateus Nery Franco", "neryfranco");
    }

    public static void setProfessorDefault(){
        professor = new Professor("contato@neryfranco.com","321","Mateus Nery Franco", "neryfranco");
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

    public static void setMatricula(Matricula matricula) {
        AlunoBundle.matricula = matricula;
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

    public static void chargeBundle(Intent intent){
        bundle.putSerializable("matricula", matricula);
        bundle.putSerializable("aluno", aluno);
        bundle.putSerializable("professor", professor);
        intent.putExtras(bundle);
    }

    public static void chargeBundle(android.support.v4.app.Fragment fragment){
        bundle.putSerializable("matricula", matricula);
        bundle.putSerializable("aluno", aluno);
        bundle.putSerializable("professor", professor);
        fragment.setArguments(bundle);
    }

    public static void loadBundle(Intent intent){
        bundle = intent.getExtras();
        matricula = (Matricula) bundle.getSerializable("matricula");
        aluno = (Aluno) bundle.getSerializable("aluno");
        professor = (Professor) bundle.getSerializable("professor");
    }
}

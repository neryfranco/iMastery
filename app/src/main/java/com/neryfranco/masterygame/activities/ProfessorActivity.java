package com.neryfranco.masterygame.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.ProfessorBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.fragments.ProfessorAlunosFragment;
import com.neryfranco.masterygame.fragments.ProfessorItensFragment;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Matricula;
import com.neryfranco.masterygame.model.Professor;

import java.util.ArrayList;

public class ProfessorActivity extends SidebarAlunoActivity {

    private ActionBarDrawerToggle sidebarBtn;

    private ProfessorItensFragment professorItensFragment;
    private ProfessorAlunosFragment professorAlunosFragment;

    private TextView value_num_alunos_atual;
    private TextView value_num_alunos_total;
    private TextView value_exp;
    private TextView value_nickname;
    private BottomNavigationView bottomNavigation;
    private Button solicitarMatriculaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_professor, null, false);
        drawer.addView(contentView, 1);

        //Sidebar Menu
        sidebarBtn = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(sidebarBtn);
        sidebarBtn.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        professorItensFragment = new ProfessorItensFragment();
        professorAlunosFragment = new ProfessorAlunosFragment();

        value_num_alunos_total = findViewById(R.id.value_num_alunos_total);
        value_num_alunos_atual = findViewById(R.id.value_num_alunos_atual);
        value_exp = findViewById(R.id.value_exp);
        value_nickname = findViewById(R.id.value_nickname);
        bottomNavigation = findViewById(R.id.bottom_navigation_prof);
        solicitarMatriculaBtn = findViewById(R.id.solicitarMatriculaBtn);

        setProfessorData();
        verificarMatricula();
        setFragment(professorAlunosFragment);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_alunos:
                        setFragment(professorAlunosFragment);
                        return true;
                    case R.id.nav_itens:
                        setFragment(professorItensFragment);
                        return true;
                    case R.id.nav_aulas:
                        return true;
                }
                return false;
            }
        });

        solicitarMatriculaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarMatricula();
            }
        });
    }

    //Selecionando Item do Sidebar Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(sidebarBtn.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SidebarAlunoActivity.setItemSelected(1);
        verificarMatricula();
        setProfessorData();
    }

    private void setProfessorData() {
        Professor professor = ProfessorBundle.getProfessor();
        Integer num_alunos_atuais = professor.getNum_alunos_atuais();
        Integer num_alunos_total = professor.getNum_alunos_total();
        Double exp = professor.getExp();
        String nickname = professor.getNick();

        value_num_alunos_atual.setText(String.valueOf(num_alunos_atuais));
        value_num_alunos_total.setText(String.valueOf(num_alunos_total));
        value_exp.setText(Double.toString(exp));
        value_nickname.setText(String.valueOf(nickname));
    }

    private void setFragment(android.support.v4.app.Fragment fragment){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
    }

    private void solicitarMatricula(){
        final Professor professor = ProfessorBundle.getProfessor();
        final Matricula matricula = AlunoBundle.getMatricula();
        final Aluno aluno = AlunoBundle.getAluno();
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);

        if(AlunoBundle.isMatriculado() && matricula.getProfessor().equals(professor)) {
            builder.setTitle(R.string.title_desmatricular_confirmation);
            builder.setMessage(R.string.description_desmatricular_confirmation);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlunoBundle.removeMatricula();
                    ProfessorBundle.removeAluno(aluno);
                    verificarMatricula();
                    setProfessorData();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
        }


        else if(!AlunoBundle.isMatriculado() && professor.getNum_alunos_atuais() < professor.getNum_max_alunos()) {
            builder.setTitle(R.string.title_matricula_confirmation);
            builder.setMessage(R.string.description_matricula_confirmation);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    AlunoBundle.newMatricula(new Matricula(professor, professor.getNum_alunos_atuais(), aluno));
                    ProfessorBundle.addAluno(aluno);
                    verificarMatricula();
                    setProfessorData();
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });

        }else{
            builder.setTitle(R.string.title_matricula_indisponivel);
            builder.setMessage(R.string.description_matricula_indisponivel);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {}});
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void verificarMatricula(){
        Aluno aluno = AlunoBundle.getAluno();
        Professor professor = ProfessorBundle.getProfessor();
        if(aluno.getMatricula() != null && aluno.getMatricula().getProfessor().equals(professor)) {
            solicitarMatriculaBtn.setText(R.string.desmatricular);
        }
        else {
            solicitarMatriculaBtn.setText(R.string.matricular);
        }
    }

}


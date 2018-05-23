package com.neryfranco.masterygame.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.fragments.HorarioFragment;
import com.neryfranco.masterygame.fragments.ItensFragment;
import com.neryfranco.masterygame.fragments.TarefasFragment;
import com.neryfranco.masterygame.model.Horario;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends AppCompatActivity {

    private BottomNavigationView bottonNavigation;
    private FrameLayout mainFrame;

    private TarefasFragment tarefasFragment;
    private ItensFragment itensFragment;
    private HorarioFragment horarioFragment;

    private Aluno aluno;
    private ArrayList<Tarefa> tarefas_aluno;
    private ArrayList<Item> itens_aluno;
    private ArrayList<Horario> horarios_aluno;

    private TextView value_level;
    private TextView value_points;
    private TextView value_exp;

    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_main);

        mainFrame = (FrameLayout) findViewById(R.id.mainFrame);
        bottonNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        value_level = (TextView) findViewById(R.id.value_level);
        value_points = (TextView) findViewById(R.id.value_points);
        value_exp = (TextView) findViewById(R.id.value_exp);
        getAlunoAtributes();

        tarefasFragment = new TarefasFragment();
        itensFragment = new ItensFragment();
        horarioFragment = new HorarioFragment();
        setFragment(tarefasFragment);

        tarefas_aluno = adicionarTarefas();

        bottonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_tasks:
                        setFragment(tarefasFragment);
                        return true;
                    case R.id.navigation_itens:
                        setFragment(itensFragment);
                        return true;
                    case R.id.navigation_schedule:
                        setFragment(horarioFragment);
                        return true;
                }
                return false;
            }
        });
    }

    private void getAlunoAtributes() {
        int level = 2;
        double exp = 101.30;
        double points = 450;

        value_level.setText(String.valueOf(level));
        value_points.setText(Double.toString(points));
        value_exp.setText(Double.toString(exp));
    }

    private void setFragment(android.support.v4.app.Fragment fragment){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
    }

    private ArrayList<Tarefa> adicionarTarefas() {
        ArrayList<Tarefa> tarefas_aluno = new ArrayList<Tarefa>();
        Tarefa e = new Tarefa("Tarefa 1",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 2",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 3",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 4",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 5",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        return tarefas_aluno;

    }
}

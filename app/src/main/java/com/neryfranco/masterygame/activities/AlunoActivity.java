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
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Horario;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Tarefa;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.ArrayList;

public class AlunoActivity extends AppCompatActivity {

    private BottomNavigationView bottonNavigation;
    private FrameLayout mainFrame;

    private TarefasFragment tarefasFragment;
    private ItensFragment itensFragment;
    private HorarioFragment horarioFragment;

    private AlunoActivity aluno;
    private ArrayList<Tarefa> tarefas_aluno;
    private ArrayList<Item> itens_aluno;
    private ArrayList<Horario> horarios_aluno;

    private TextView value_level;
    private TextView value_points;
    private TextView value_exp;
    private TextView value_nickname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_main);

        mainFrame = (FrameLayout) findViewById(R.id.mainFrame);
        bottonNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        value_level = (TextView) findViewById(R.id.value_level);
        value_points = (TextView) findViewById(R.id.value_points);
        value_exp = (TextView) findViewById(R.id.value_exp);
        value_nickname = (TextView) findViewById(R.id.text_nickname);

        tarefasFragment = new TarefasFragment();
        itensFragment = new ItensFragment();
        horarioFragment = new HorarioFragment();

        Aluno aluno = new Aluno("email@email.com", "123", "Mateus Nery Franco", "neryfranco");
        tarefas_aluno = adicionarTarefas();
        horarios_aluno = adicionarHorarios();
        itens_aluno = adicionarItens();

        setAlunoData(aluno);
        setFragment(tarefasFragment, tarefas_aluno);

        bottonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Bundle bundle = new Bundle();
                switch (item.getItemId()) {
                    case R.id.navigation_tasks:
                        setFragment(tarefasFragment, tarefas_aluno);
                        return true;
                    case R.id.navigation_itens:
                        setFragment(itensFragment, itens_aluno);
                        return true;
                    case R.id.navigation_schedule:
                        setFragment(horarioFragment, horarios_aluno);
                        return true;
                }
                return false;
            }
        });
    }

    private void setAlunoData(Aluno aluno) {
        Integer level = aluno.getLevel();
        Double exp = aluno.getExp();
        Double points = 0.0;
        String nickname = aluno.getNick();

        value_level.setText(String.valueOf(level));
        value_points.setText(Double.toString(points));
        value_exp.setText(Double.toString(exp));
        value_nickname.setText(String.valueOf(nickname));
    }

    private void setFragment(android.support.v4.app.Fragment fragment, ArrayList list){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", list);
        fragment.setArguments(bundle);
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


    private ArrayList<Item> adicionarItens() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item e = new Item(1,"Item 1", 100.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(2,"Item 2", 200.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(3,"Item 3", 300.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(4,"Item 4", 400.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        return items;

    }

    public ArrayList<Horario> adicionarHorarios() {
        ArrayList<Horario> horarios = new ArrayList<Horario>();
        Horario e;

        e = new Horario(Time.valueOf("11:00:00"),2);
        horarios.add(e);
        e = new Horario(Time.valueOf("11:00:00"),4);
        horarios.add(e);
        e = new Horario(Time.valueOf("11:00:00"),6);
        horarios.add(e);

        return horarios;
    }
}

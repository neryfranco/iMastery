package com.neryfranco.masterygame.activities;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.fragments.ItensFragment;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Item;

import java.util.ArrayList;

public class ProfessorActivity extends SidebarAlunoActivity {

    private ActionBarDrawerToggle sidebarBtn;

    private ArrayList<Aluno> lista_alunos;
    private ArrayList<Item> lista_itens;

    private ItensFragment itensFragment;

    private TextView value_num_alunos_atual;
    private TextView value_num_alunos_total;
    private TextView value_exp;
    private TextView value_nickname;
    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_professor, null, false);
        drawer.addView(contentView, 1);
        professor = AlunoBundle.getProfessor();

        lista_itens = new ArrayList<>();
        lista_alunos = new ArrayList<>();

        //Sidebar Menu
        sidebarBtn = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(sidebarBtn);
        sidebarBtn.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        itensFragment = new ItensFragment();

        value_num_alunos_total = findViewById(R.id.value_num_alunos_total);
        value_num_alunos_atual = findViewById(R.id.value_num_alunos_atual);
        value_exp = findViewById(R.id.value_exp);
        value_nickname = findViewById(R.id.value_nickname);
        bottomNavigation = findViewById(R.id.bottom_navigation_prof);

        lista_itens = adicionarItens();
        setProfessorData();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_alunos:
                        return true;
                    case R.id.nav_itens:
                        setFragment(itensFragment, lista_itens);
                        return true;
                    case R.id.nav_aulas:
                        return true;
                }
                return false;
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
    }

    private void setProfessorData() {
        Integer num_alunos_atuais = professor.getNum_alunos_atuais();
        Integer num_alunos_total = professor.getNum_alunos_total();
        Double exp = professor.getExp();
        String nickname = professor.getNick();

        value_num_alunos_atual.setText(String.valueOf(num_alunos_atuais));
        value_num_alunos_total.setText(Double.toString(num_alunos_total));
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

    private ArrayList<Item> adicionarItens() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item e = new Item(1,"Item 1", "Descricao do Item...",100.0, 300.0, 5);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(2,"Item 2", "Descricao do Item...",200.0, 500.0, 10);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(3,"Item 3", "Descricao do Item...",300.0, 800.0, 7);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(4,"Item 4", "Descricao do Item...",400.0, 1000.0, 30);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        return items;

    }

}


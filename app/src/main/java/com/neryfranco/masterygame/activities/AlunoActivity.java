package com.neryfranco.masterygame.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.fragments.HorarioFragment;
import com.neryfranco.masterygame.fragments.ItensFragment;
import com.neryfranco.masterygame.fragments.TarefasFragment;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Matricula;
import com.neryfranco.masterygame.model.Tarefa;

import java.util.ArrayList;

public class AlunoActivity extends SidebarAlunoActivity{

    private BottomNavigationView bottonNavigation;
    private FrameLayout mainFrame;
    private ActionBarDrawerToggle sidebarBtn;

    private TarefasFragment tarefasFragment;
    private ItensFragment itensFragment;
    private HorarioFragment horarioFragment;

    private TextView value_level;
    private TextView value_points;
    private TextView value_exp;
    private TextView value_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_aluno_main, null, false);
        drawer.addView(contentView, 0);

        mainFrame = (FrameLayout) findViewById(R.id.mainFrame);
        bottonNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        //Sidebar Menu
        //sidebarMenu = (DrawerLayout) findViewById(R.id.bottom_navigation);
        sidebarBtn = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(sidebarBtn);
        sidebarBtn.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SidebarAlunoActivity.setItemSelected(0);

        value_level = (TextView) findViewById(R.id.value_level);
        value_points = (TextView) findViewById(R.id.value_points);
        value_exp = (TextView) findViewById(R.id.value_exp);
        value_nickname = (TextView) findViewById(R.id.text_nickname);

        tarefasFragment = new TarefasFragment();
        itensFragment = new ItensFragment();
        horarioFragment = new HorarioFragment();

        //Setando os dados do aluno
        setAlunoData();
        setFragment(tarefasFragment);

        bottonNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_tarefas:
                        setFragment(tarefasFragment);
                        return true;

                    case R.id.nav_itens:
                        setFragment(itensFragment);
                        return true;

                    case R.id.nav_horarios:
                        setFragment(horarioFragment);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        SidebarAlunoActivity.setItemSelected(0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setFragment(tarefasFragment);
        SidebarAlunoActivity.setItemSelected(0);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SidebarAlunoActivity.setItemSelected(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    //Selecionando Item do Sidebar Menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(sidebarBtn.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void setAlunoData() {
        Aluno aluno = AlunoBundle.getAluno();
        Matricula matricula = AlunoBundle.getMatricula();
        Double exp = 0.0;
        Double points = 0.0;

        Integer level = aluno.getLevel();
        String nickname = aluno.getNick();
        exp = aluno.getExp();
        if(matricula != null) points = matricula.getPoints();

        value_level.setText(String.valueOf(level));
        value_points.setText(Double.toString(points));
        value_exp.setText(Double.toString(exp));
        value_nickname.setText(String.valueOf(nickname));
    }

    public void setFragment(android.support.v4.app.Fragment fragment){
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putSerializable("aluno", AlunoBundle.getAluno());
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.mainFrame, fragment);
        fragmentTransaction.commit();
    }

    private void verificarMatricula(){
        if(AlunoBundle.getAluno().getMatricula() == null){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(R.string.title_matricula_inexistente);
            builder.setMessage(R.string.description_matricula_inexistente);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), ProfessorActivity.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

}

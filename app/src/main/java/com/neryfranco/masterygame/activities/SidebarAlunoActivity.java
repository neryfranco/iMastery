package com.neryfranco.masterygame.activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Professor;

public class SidebarAlunoActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout drawer;
    protected Aluno aluno;
    protected Professor professor;
    private Bundle bundle;
    private static NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar_aluno);

        drawer = (DrawerLayout) findViewById(R.id.sidebarMenuAluno);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.sidebarMenuAluno);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sidebar_aluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        bundle = getIntent().getExtras();
        aluno = (Aluno) bundle.getSerializable("aluno");
        professor = (Professor) bundle.getSerializable("professor");

        if (id == R.id.meuPerfil_menu) {
            Intent intent = new Intent(getApplicationContext(), AlunoActivity.class);
            bundle.putSerializable("aluno", aluno);
            bundle.putSerializable("professor", professor);
            intent.putExtras(bundle);
            startActivity(intent);

        } else if (id == R.id.professor_menu) {
            Intent intent = new Intent(getApplicationContext(), ProfessorActivity.class);
            bundle.putSerializable("aluno", aluno);
            bundle.putSerializable("professor", professor);
            intent.putExtras(bundle);
            startActivity(intent);

        } else if (id == R.id.aulas_menu) {

        } else if (id == R.id.config_menu) {

        } else if (id == R.id.logout) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.sidebarMenuAluno);
            drawer.closeDrawer(GravityCompat.START);
            return true;
    }

    public static void setItemSelected(int id){
        navigationView.getMenu().getItem(id).setChecked(true);
    }
}

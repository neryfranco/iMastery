package com.neryfranco.masterygame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Matricula;
import com.neryfranco.masterygame.model.Tarefa;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.nio.DoubleBuffer;
import java.util.List;

public class DetailsTarefasActivity extends AppCompatActivity{

    private TextView title;
    private TextView description;
    private TextView points;
    private TextView exp;
    private TextView aula;
    private TextView professor;
    private RatingBar ratingBar;
    private Button enviarTarefaBtn;
    private Tarefa tarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_details);

        Bundle bundle = getIntent().getExtras();
        tarefa = (Tarefa) bundle.getSerializable("tarefa");
        getIntent().getExtras().remove("lista");

        title = (TextView) findViewById(R.id.tarefa_title);
        description = (TextView) findViewById(R.id.tarefa_description);
        points = (TextView) findViewById(R.id.task_points_value);
        exp = (TextView) findViewById(R.id.task_exp_value);
        aula = (TextView) findViewById(R.id.value_aulaAssociada);
        professor = (TextView) findViewById(R.id.value_professorTarefa);
        ratingBar = (RatingBar) findViewById(R.id.tarefa_ratingBar);
        enviarTarefaBtn = (Button) findViewById(R.id.concluirTarefaBtn);
        setInfo();

        enviarTarefaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizarTarefa();
                Intent intent = new Intent(getApplicationContext(), AlunoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setInfo(){
        Double p = tarefa.getPoints();
        Double e = tarefa.getExp();

        title.setText(tarefa.getTitulo());
        description.setText(tarefa.getDescricao());
        points.setText(p.toString());
        exp.setText(e.toString());
        ratingBar.setNumStars(tarefa.getReputacao());
        professor.setText(tarefa.getMatricula().getProfessor().getNick());
    }

    private void finalizarTarefa(){
        Double p = tarefa.getPoints();
        Double e = tarefa.getExp();

        AlunoBundle.getMatricula().addPoints(p);
        AlunoBundle.getMatricula().addExp(e);
        AlunoBundle.removeTarefa(tarefa);
    }
}

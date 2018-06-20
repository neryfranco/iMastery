package com.neryfranco.masterygame.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Tarefa;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.nio.DoubleBuffer;
import java.util.List;

public class TarefasDetailsActivity extends AppCompatActivity{

    private TextView title;
    private TextView description;
    private TextView points;
    private TextView exp;
    private TextView aula;
    private TextView professor;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_details);

        Bundle bundle = getIntent().getExtras();
        Tarefa tarefa = (Tarefa) bundle.getSerializable("tarefa");
        getIntent().getExtras().remove("lista");

        title = (TextView) findViewById(R.id.tarefa_title);
        description = (TextView) findViewById(R.id.tarefa_description);
        points = (TextView) findViewById(R.id.task_points_value);
        exp = (TextView) findViewById(R.id.task_exp_value);
        aula = (TextView) findViewById(R.id.value_aulaAssociada);
        professor = (TextView) findViewById(R.id.value_professorTarefa);
        ratingBar = (RatingBar) findViewById(R.id.tarefa_ratingBar);

        setInfo(tarefa);
    }

    public void setInfo(Tarefa tarefa){
        Double p = tarefa.getPoints();
        Double e = tarefa.getExp();

        title.setText(tarefa.getTitulo());
        description.setText(tarefa.getDescricao());
        points.setText(p.toString());
        exp.setText(e.toString());
        ratingBar.setNumStars(tarefa.getReputacao());
        professor.setText(tarefa.getMatricula().getProfessor().getNick());
    }
}

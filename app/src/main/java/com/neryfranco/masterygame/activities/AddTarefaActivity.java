package com.neryfranco.masterygame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.neryfranco.masterygame.ProfessorBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Aula;
import com.neryfranco.masterygame.model.Tarefa;

public class AddTarefaActivity extends AppCompatActivity {

    private TextView nickname;
    private EditText titulo;
    private EditText descricao;
    private EditText exp;
    private EditText points;
    private TextView aulaView;
    private Button criarTarefaBtn;

    private String sTitulo;
    private String sDescricao;
    private Double dExp;
    private Double dPoints;
    private Aula aula;
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_add);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            aluno = (Aluno) bundle.getSerializable("aluno");
            aula = (Aula) bundle.getSerializable("aula");
            getIntent().getExtras().remove("aula");
            getIntent().getExtras().remove("aluno");
        }

        nickname = findViewById(R.id.aluno_nickname);
        titulo = findViewById(R.id.titulo_value);
        descricao = findViewById(R.id.descricao_value);
        exp = findViewById(R.id.exp_value);
        points = findViewById(R.id.pontos_value);
        aulaView = findViewById(R.id.aulaAssociada_value);
        criarTarefaBtn = findViewById(R.id.criarTarefaBtn);
        if(aluno != null) nickname.setText(aluno.getNick());
        if(aula != null) aulaView.setText(aula.getTitulo());

        criarTarefaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(criarTarefa()){
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private boolean criarTarefa(){
        if(validate()) {
            sTitulo = titulo.getText().toString();
            sDescricao = descricao.getText().toString();
            dExp = Double.parseDouble(exp.getText().toString());
            dPoints = Double.parseDouble(points.getText().toString());

            Tarefa tarefa = new Tarefa(sTitulo, sDescricao, dExp, dPoints, null, ProfessorBundle.getProfessor());
            if(aula != null) {
                tarefa.setAula(aula);
                aula.addTarefa(tarefa);
            }
            if(aluno != null) tarefa.setAluno(aluno);
            returnTarefa(tarefa);
            return true;
        }
        return false;
    }

    private boolean validate(){
        if(titulo.getText().length() <= 0){
            titulo.setError("Campo vazio");
            return false;
        }
        if(descricao.getText().length() <= 0){
            descricao.setError("Campo vazio");
            return false;
        }
        if(exp.getText().length() <= 0){
            exp.setError("Campo vazio");
            return false;
        }
        if(points.getText().length() <= 0){
            points.setError("Campo vazio");
            return false;
        }
        else return true;
    }

    private void returnTarefa(Tarefa tarefa){
        Bundle bundle = new Bundle();
        bundle.putSerializable("tarefa", tarefa);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
    }
}

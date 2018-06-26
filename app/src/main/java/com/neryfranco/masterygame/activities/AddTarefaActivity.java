package com.neryfranco.masterygame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.fragments.TarefasFragment;
import com.neryfranco.masterygame.model.Tarefa;

public class AddTarefaActivity extends AppCompatActivity {

    private TextView nickname;
    private EditText titulo;
    private EditText descricao;
    private EditText exp;
    private EditText points;
    private Spinner aula;
    private Button criarTarefaBtn;

    private String sTitulo;
    private String sDescricao;
    private Double dExp;
    private Double dPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarefa_add);

        nickname = findViewById(R.id.aluno_nickname);
        titulo = findViewById(R.id.titulo_value);
        descricao = findViewById(R.id.descricao_value);
        exp = findViewById(R.id.exp_value);
        points = findViewById(R.id.pontos_value);
        aula = findViewById(R.id.aula_value);
        criarTarefaBtn = findViewById(R.id.criarTarefaBtn);

        nickname.setText(AlunoBundle.getAluno().getNick());

        criarTarefaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(criarTarefa()){
                    Intent intent = new Intent(getApplicationContext(),AlunoActivity.class);
                    startActivity(intent);
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

            Tarefa tarefa = new Tarefa(sTitulo, sDescricao, dExp, dPoints, null, AlunoBundle.getMatricula());
            AlunoBundle.addTarefa(tarefa);
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
}

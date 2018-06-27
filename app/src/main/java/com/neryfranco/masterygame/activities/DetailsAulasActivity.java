package com.neryfranco.masterygame.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.adapter.Tarefas_Adapter;
import com.neryfranco.masterygame.model.Aula;
import com.neryfranco.masterygame.model.Tarefa;

import java.util.ArrayList;

public class DetailsAulasActivity extends AppCompatActivity {

    private Aula aula;
    private ArrayList<Tarefa> lista;
    private TextView titulo;
    private TextView descricao;
    private TextView professor;
    private TextView preRequisito;
    private Button addTarefa;
    private Button getTarefa;
    private ListView listaTarefasView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_aulas);

        Bundle bundle = getIntent().getExtras();
        aula = (Aula) bundle.getSerializable("aula");
        getIntent().getExtras().remove("aula");

        titulo = findViewById(R.id.aula_title);
        descricao = findViewById(R.id.aula_description);
        professor = findViewById(R.id.prof_value);
        preRequisito = findViewById(R.id.preRequisito_value);
        addTarefa = findViewById(R.id.addTarefaButton);
        getTarefa = findViewById(R.id.adquirirTarefasBtn);
        listaTarefasView = findViewById(R.id.listTarefas);

        setInfo();
    }

    public void setInfo(){
        if(aula != null) {
            titulo.setText(aula.getTitulo());
            descricao.setText(aula.getDescricao());
            if(aula.getProfessor() != null)
                professor.setText(aula.getProfessor().getNick());
            if(!aula.getPre_requisitos().isEmpty()) {
                String pr = aula.getPre_requisitos().get(0).getTitulo();
                preRequisito.setText(pr);
            }
            ArrayAdapter adapter = new Tarefas_Adapter(this, aula.getTarefas());
            listaTarefasView.setAdapter(adapter);
        }
    }
}

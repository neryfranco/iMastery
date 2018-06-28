package com.neryfranco.masterygame.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.neryfranco.masterygame.AlunoBundle;
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
    private Integer REQUEST = 1;

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
        addTarefa = findViewById(R.id.addTarefaBtn);
        getTarefa = findViewById(R.id.adquirirTarefasBtn);
        listaTarefasView = findViewById(R.id.listTarefas);
        setInfo();

        addTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("aula", aula);
                Intent intent = new Intent(getApplicationContext(), AddTarefaActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST);
            }
        });

        if(AlunoBundle.getMatricula()== null ||
                AlunoBundle.getMatricula().getProfessor().getId() != aula.getProfessor().getId()) {
            getTarefa.setEnabled(false);
        }

        getTarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alunoGetTarefa();
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST) {
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                Tarefa tarefa = (Tarefa) bundle.getSerializable("tarefa");
                aula.addTarefa(tarefa);
                setInfo();
            }
        }
    }

    private void alunoGetTarefa(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(AlunoBundle.adquirirTarefas(aula.getTarefas())){
            builder.setTitle(R.string.tarefas_adquiridas_title);
            builder.setMessage(R.string.tarefas_adquiridas_description);
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
        }
        else{
            Toast.makeText(getApplicationContext(), "Houve um erro ao adquirir tarefas",
                    Toast.LENGTH_SHORT).show();
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

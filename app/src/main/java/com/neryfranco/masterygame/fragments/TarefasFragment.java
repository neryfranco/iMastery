package com.neryfranco.masterygame.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.activities.AddTarefaActivity;
import com.neryfranco.masterygame.adapter.Tarefas_Adapter;
import com.neryfranco.masterygame.model.Tarefa;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TarefasFragment extends Fragment{

    private ListView lista;
    private ArrayList<Tarefa> tarefas;
    private FloatingActionButton addTarefaBtn;

    public TarefasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tarefas, container, false);

        lista = (ListView) rootView.findViewById(R.id.listTarefas);
        addTarefaBtn = (FloatingActionButton) rootView.findViewById(R.id.addTarefaButton);
        ArrayAdapter adapter = new Tarefas_Adapter(this.getContext(), AlunoBundle.getTarefas());
        lista.setAdapter(adapter);
        verificaMatricula();

        addTarefaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddTarefaActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private void verificaMatricula(){
        if(AlunoBundle.getAluno().getMatricula() == null) addTarefaBtn.setVisibility(View.INVISIBLE);
        else addTarefaBtn.setVisibility(View.VISIBLE);
    }

}

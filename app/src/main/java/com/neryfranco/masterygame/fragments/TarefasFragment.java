package com.neryfranco.masterygame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.adapter.Tarefas_Adapter;
import com.neryfranco.masterygame.model.Tarefa;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TarefasFragment extends Fragment {

    private ListView lista;
    private ArrayList<Tarefa> tarefas;

    public TarefasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tarefas, container, false);

        lista = (ListView) rootView.findViewById(R.id.listTasks);
        tarefas = adicionarTarefas();
        ArrayAdapter adapter = new Tarefas_Adapter(this.getContext(), tarefas);
        lista.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Tarefa> adicionarTarefas() {
        ArrayList<Tarefa> tarefas_aluno = new ArrayList<Tarefa>();
        Tarefa e = new Tarefa("Tarefa 1",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 2",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 3",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 4",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        e = new Tarefa("Tarefa 5",
                "Descrição da tarefa...");
        tarefas_aluno.add(e);
        return tarefas_aluno;

    }
}

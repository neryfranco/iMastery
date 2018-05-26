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

import java.io.Serializable;
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

        lista = (ListView) rootView.findViewById(R.id.listTarefas);
        Bundle bundle = getArguments();
        tarefas = (ArrayList<Tarefa>) bundle.getSerializable("lista");
        ArrayAdapter adapter = new Tarefas_Adapter(this.getContext(), tarefas);
        lista.setAdapter(adapter);

        return rootView;
    }

}

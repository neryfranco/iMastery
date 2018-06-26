package com.neryfranco.masterygame.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neryfranco.masterygame.ProfessorBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.adapter.Alunos_Adapter;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Professor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfessorAlunosFragment extends Fragment {

    private ListView lista;
    private ArrayList<Aluno> alunos;

    public ProfessorAlunosFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_alunos, container, false);

        lista = (ListView) rootView.findViewById(R.id.listAlunos);
        ArrayAdapter adapter = new Alunos_Adapter(this.getContext(), ProfessorBundle.getAlunos());
        lista.setAdapter(adapter);

        return rootView;
    }
}

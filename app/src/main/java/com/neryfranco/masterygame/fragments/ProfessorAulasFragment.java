package com.neryfranco.masterygame.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.ProfessorBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.adapter.Aulas_Adapter;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Professor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfessorAulasFragment extends Fragment {

    private ListView lista;

    public ProfessorAulasFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_aulas, container, false);

        lista = (ListView) rootView.findViewById(R.id.listAulas);
        ArrayAdapter adapter = new Aulas_Adapter(this.getContext(), ProfessorBundle.getAulas());
        lista.setAdapter(adapter);

        return rootView;
    }
}

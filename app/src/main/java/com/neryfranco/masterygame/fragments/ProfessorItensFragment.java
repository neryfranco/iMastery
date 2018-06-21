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
import com.neryfranco.masterygame.adapter.Itens_Adapter;
import com.neryfranco.masterygame.model.Item;
import com.neryfranco.masterygame.model.Professor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfessorItensFragment extends Fragment {

    private ListView lista;

    public ProfessorItensFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_itens, container, false);

        lista = (ListView) rootView.findViewById(R.id.listItens);
        ArrayAdapter adapter = new Itens_Adapter(this.getContext(), ProfessorBundle.getItens());
        lista.setAdapter(adapter);

        return rootView;
    }
}

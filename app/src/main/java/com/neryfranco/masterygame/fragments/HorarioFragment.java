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
import com.neryfranco.masterygame.activities.HorarioAddActivity;
import com.neryfranco.masterygame.adapter.Horario_Adapter;
import com.neryfranco.masterygame.model.Horario;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HorarioFragment extends Fragment {

    private static ListView lista;
    private static ArrayAdapter adapter;
    private static ArrayList<Horario> horarios;
    private FloatingActionButton addButton;
    private Bundle bundle;

    public HorarioFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_horario, container, false);

        lista = (ListView) rootView.findViewById(R.id.listHorarios);
        horarios = AlunoBundle.getAluno().getHorarios();
        adapter = new Horario_Adapter(this.getContext(), horarios);
        lista.setAdapter(adapter);
        addButton = (FloatingActionButton) rootView.findViewById(R.id.addHorarioButton);

        //Adicionar Horário
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inflater.getContext(), HorarioAddActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                inflater.getContext().startActivity(intent);
            }
        });

        return rootView;
    }



    public static void deleteHorario(Horario h){
        adapter.remove(h);
        lista.setAdapter(adapter);
    }

}

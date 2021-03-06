package com.neryfranco.masterygame.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.activities.DetailsTarefasActivity;
import com.neryfranco.masterygame.model.Tarefa;

import java.util.ArrayList;

public class Tarefas_Adapter extends ArrayAdapter<Tarefa> {

    private final Context context;
    private final ArrayList<Tarefa> elementos;

    public Tarefas_Adapter(Context context, ArrayList<Tarefa> elementos) {
        super(context, R.layout.element_tarefa, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.element_tarefa, parent, false);
        TextView titulo = (TextView) rowView.findViewById(R.id.tarefa_title);
        TextView descricao = (TextView) rowView.findViewById(R.id.tarefa_description);
        titulo.setText(elementos.get(position).getTitulo());
        descricao.setText(elementos.get(position).getDescricao());

        ConstraintLayout details = (ConstraintLayout) rowView.findViewById(R.id.tarefaDetailsBtn);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsTarefasActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("tarefa", elementos.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}

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
import com.neryfranco.masterygame.activities.DetailsAulasActivity;
import com.neryfranco.masterygame.model.Aula;

import java.util.ArrayList;

public class Aulas_Adapter extends ArrayAdapter<Aula> {

    private final Context context;
    private final ArrayList<Aula> elementos;

    public Aulas_Adapter(Context context, ArrayList<Aula> elementos) {
        super(context, R.layout.element_aula, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.element_aula, parent, false);
        TextView titulo = (TextView) rowView.findViewById(R.id.aula_title);
        TextView descricao = (TextView) rowView.findViewById(R.id.aula_description);
        titulo.setText(elementos.get(position).getTitulo());
        descricao.setText(elementos.get(position).getDescricao());

        ConstraintLayout details = (ConstraintLayout) rowView.findViewById(R.id.aulaDetailsBtn);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsAulasActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("aula", elementos.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}

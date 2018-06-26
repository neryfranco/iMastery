package com.neryfranco.masterygame.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.activities.AlunoActivity;
import com.neryfranco.masterygame.model.Aluno;

import java.util.ArrayList;

/**
 * Created by Nery on 13/05/2018.
 */

public class Alunos_Adapter extends ArrayAdapter {

    private final Context context;
    private final ArrayList<Aluno> elementos;

    public Alunos_Adapter(Context context, ArrayList<Aluno> elementos) {
        super(context, R.layout.element_aluno, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.element_aluno, parent, false);

        TextView nickname = (TextView) rowView.findViewById(R.id.aluno_nickname);
        TextView exp = (TextView) rowView.findViewById(R.id.aluno_exp);
        nickname.setText(elementos.get(position).getNick());
        exp.setText(elementos.get(position).getExp().toString());

        ConstraintLayout details = (ConstraintLayout) rowView.findViewById(R.id.element_aluno);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AlunoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("aluno", elementos.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}

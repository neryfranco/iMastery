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
import com.neryfranco.masterygame.activities.DetailsItensActivity;
import com.neryfranco.masterygame.model.Item;

import java.util.ArrayList;

/**
 * Created by Nery on 13/05/2018.
 */

public class Itens_Adapter extends ArrayAdapter {

    private final Context context;
    private final ArrayList<Item> elementos;

    public Itens_Adapter(Context context, ArrayList<Item> elementos) {
        super(context, R.layout.element_item, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.element_item, parent, false);

        TextView titulo = (TextView) rowView.findViewById(R.id.item_title);
        TextView descricao = (TextView) rowView.findViewById(R.id.item_description);
        titulo.setText(elementos.get(position).getTitulo());
        descricao.setText(elementos.get(position).getDescricao());

        ConstraintLayout details = (ConstraintLayout) rowView.findViewById(R.id.element_item);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsItensActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle bundle = new Bundle();
                bundle.putSerializable("item", elementos.get(position));
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}

package com.neryfranco.masterygame.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.fragments.HorarioFragment;
import com.neryfranco.masterygame.model.Horario;

import java.util.ArrayList;

public class Horario_Adapter extends ArrayAdapter {

    private final Context context;
    private final ArrayList<Horario> elementos;

    public Horario_Adapter(Context context, ArrayList<Horario> elementos) {
        super(context, R.layout.element_horario, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.element_horario, parent, false);

        TextView titulo = (TextView) rowView.findViewById(R.id.horario_title);
        titulo.setText(elementos.get(position).getDiaHora());

        ImageView trash = (ImageView) rowView.findViewById(R.id.horario_trash);
        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setCancelable(true);
                builder.setTitle(R.string.delete_schedule_title);
                builder.setMessage(R.string.delete_schedule_text);
                builder.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                HorarioFragment.deleteHorario(elementos.get(position));
                            }
                        });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return rowView;
    }
}

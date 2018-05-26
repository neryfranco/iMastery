package com.neryfranco.masterygame.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DigitalClock;
import android.widget.TextClock;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Horario;

public class HorarioAddActivity extends AppCompatActivity {

    private Button confirmar;
    private CheckBox segunda;
    private CheckBox terca;
    private CheckBox quarta;
    private CheckBox quinta;
    private CheckBox sexta;
    private CheckBox sabado;
    private CheckBox domingo;
    private DigitalClock clock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_new);

        confirmar = (Button) findViewById(R.id.confirmar_btn);
        segunda = (CheckBox) findViewById(R.id.segunda_btn);
        terca = (CheckBox) findViewById(R.id.terca_btn);
        quarta = (CheckBox) findViewById(R.id.quarta_btn);
        quinta = (CheckBox) findViewById(R.id.quinta_btn);
        sexta = (CheckBox) findViewById(R.id.sexta_btn);
        sabado = (CheckBox) findViewById(R.id.sabado_btn);
        domingo = (CheckBox) findViewById(R.id.domingo_btn);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}

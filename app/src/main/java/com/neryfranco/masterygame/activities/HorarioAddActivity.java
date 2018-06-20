package com.neryfranco.masterygame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Horario;
import com.neryfranco.masterygame.model.SetTime;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class HorarioAddActivity extends AppCompatActivity {

    private Button confirmar;
    private CheckBox segunda;
    private CheckBox terca;
    private CheckBox quarta;
    private CheckBox quinta;
    private CheckBox sexta;
    private CheckBox sabado;
    private CheckBox domingo;
    private TextView clock;
    private ArrayList<Horario> horarios;
    private Aluno aluno;

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
        clock = (EditText) findViewById(R.id.clock_btn);
        aluno = AlunoBundle.getAluno();
        horarios = aluno.getHorarios();
        new SetTime(clock);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    createHorarios();
                    aluno.setHorarios(horarios);
                    Intent intent = new Intent(getApplicationContext(),AlunoActivity.class);
                    startActivity(intent);
                } catch (ParseException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Horário Inválido",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void createHorarios() throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        Date data = formatador.parse(clock.getText().toString());
        Time time = new Time(data.getTime());
        if (!time.equals(null)) {
            if (domingo.isChecked()) horarios.add(new Horario(time, 1));
            if (segunda.isChecked()) horarios.add(new Horario(time, 2));
            if (terca.isChecked()) horarios.add(new Horario(time, 3));
            if (quarta.isChecked()) horarios.add(new Horario(time, 4));
            if (quinta.isChecked()) horarios.add(new Horario(time, 5));
            if (sexta.isChecked()) horarios.add(new Horario(time, 6));
            if (sabado.isChecked()) horarios.add(new Horario(time, 7));
        }
    }
}

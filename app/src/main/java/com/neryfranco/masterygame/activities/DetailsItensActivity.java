package com.neryfranco.masterygame.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Aluno;
import com.neryfranco.masterygame.model.Item;

public class DetailsItensActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView points;
    private TextView cash;
    private TextView validade;
    private TextView cod;
    private Item item;
    private Button comprarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_details);

        Bundle bundle = getIntent().getExtras();
        item = (Item) bundle.getSerializable("item");
        getIntent().getExtras().remove("item");

        title = (TextView) findViewById(R.id.item_title);
        description = (TextView) findViewById(R.id.item_description);
        points = (TextView) findViewById(R.id.item_points);
        cash = (TextView) findViewById(R.id.item_cash);
        validade = (TextView) findViewById(R.id.item_validade);
        comprarBtn = (Button) findViewById(R.id.comprarItem_btn);
        cod = findViewById(R.id.cod_value);

        if(AlunoBundle.containItem(item)){
            comprarBtn.setVisibility(View.INVISIBLE);
            comprarBtn.setClickable(false);
            Toast.makeText(getApplicationContext(), AlunoBundle.getItens().size(),
                    Toast.LENGTH_LONG).show();
        }
        comprarBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(DetailsItensActivity.this);
                builder.setCancelable(true);

                if(AlunoBundle.getMatricula() != null){
                    if(AlunoBundle.getMatricula().getPoints() >= item.getPoints()){
                        AlunoBundle.addItem(item);
                        builder.setTitle(R.string.item_adquirido_title);
                        builder.setMessage(R.string.item_adquirido_description);
                        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });
                    }
                    else{
                        builder.setTitle(R.string.points_insuficiente_title);
                        builder.setMessage(R.string.points_insuficiente_description);
                        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                    }
                }
                else{
                    builder.setTitle(R.string.title_matricula_inexistente);
                    builder.setMessage(R.string.description_matricula_inexistente);
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                }
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        setInfo();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void setInfo(){

        title.setText(item.getTitulo());
        description.setText(item.getDescricao());
        cod.setText(item.getId().toString());

        if(item.getValidade() == null) validade.setText("Não se aplica");
        else validade.setText(item.getValidade().toString() + " dias");

        if(item.getPoints() == null) points.setText("Não se aplica");
        else points.setText(item.getPoints().toString());

        if(item.getCash() == null) cash.setText("Não se aplica");
        else cash.setText(item.getCash().toString());
    }
}

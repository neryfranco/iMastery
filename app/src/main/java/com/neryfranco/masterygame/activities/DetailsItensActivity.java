package com.neryfranco.masterygame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Item;

public class DetailsItensActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView points;
    private TextView cash;
    private TextView validade;
    private Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_details);

        Bundle bundle = getIntent().getExtras();
        item = (Item) bundle.getSerializable("item");
        getIntent().getExtras().remove("lista");

        title = (TextView) findViewById(R.id.item_title);
        description = (TextView) findViewById(R.id.item_description);
        points = (TextView) findViewById(R.id.item_points);
        cash = (TextView) findViewById(R.id.item_cash);
        validade = (TextView) findViewById(R.id.item_validade);

        setInfo();
    }

    public void setInfo(){

        title.setText(item.getTitulo());
        description.setText(item.getDescricao());

        if(item.getValidade() == null) validade.setText("Não se aplica");
        else validade.setText(item.getValidade().toString() + " dias");

        if(item.getPoints() == null) points.setText("Não se aplica");
        else points.setText(item.getPoints().toString());

        if(item.getCash() == null) cash.setText("Não se aplica");
        else cash.setText(item.getCash().toString());
    }
}

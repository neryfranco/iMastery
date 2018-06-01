package com.neryfranco.masterygame.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Item;

public class ItensDetailsActivity extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView points;
    private TextView cash;
    private TextView validade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens_details);

        Bundle bundle = getIntent().getExtras();
        Item item = (Item) bundle.getSerializable("item");
        getIntent().getExtras().remove("lista");

        title = (TextView) findViewById(R.id.item_title);
        description = (TextView) findViewById(R.id.item_description);
        points = (TextView) findViewById(R.id.item_points);
        cash = (TextView) findViewById(R.id.item_cash);
        validade = (TextView) findViewById(R.id.item_validade);

        setInfo(item);
    }

    public void setInfo(Item item){
        Double p = item.getPoints();
        Double e = item.getCash();

        title.setText(item.getTitulo());
        description.setText(item.getDescricao());
        points.setText(p.toString());
        cash.setText(e.toString());
        validade.setText(item.getValidade().toString() + " dias");
    }
}

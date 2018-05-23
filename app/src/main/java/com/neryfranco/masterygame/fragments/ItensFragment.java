package com.neryfranco.masterygame.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.adapter.Itens_Adapter;
import com.neryfranco.masterygame.model.Item;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItensFragment extends Fragment {

    private ListView lista;

    public ItensFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_itens, container, false);

        lista = (ListView) rootView.findViewById(R.id.listItens);
        ArrayList<Item> items = adicionarTasks();
        ArrayAdapter adapter = new Itens_Adapter(this.getContext(), items);
        lista.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Item> adicionarTasks() {
        ArrayList<Item> items = new ArrayList<Item>();
        Item e = new Item(1,"Item 1", 100.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(2,"Item 2", 200.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(3,"Item 3", 300.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        e = new Item(4,"Item 4", 400.0);
        e.setDescricao("Descrição do Item...");
        items.add(e);
        return items;

    }
}

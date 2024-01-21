package com.pedraza.crudapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class Adapter extends ArrayAdapter<Juegos> {


    Context context;
    List<Juegos>juegosList;

    public Adapter(@NonNull Context context, List<Juegos>JuegosList) {
        super(context,R.layout.list_juegos,JuegosList);
        this.context=context;
        this.juegosList=JuegosList;
    }

    public View getView( int position, @NonNull View context, ViewGroup resource) {
        View view= LayoutInflater.from(resource.getContext()).inflate(R.layout.list_juegos,null,true);
        TextView tvid=view.findViewById(R.id.txt_id);
        TextView tvtitulo=view.findViewById(R.id.txt_name);

        tvid.setText(juegosList.get(position).getId());
        tvtitulo.setText(juegosList.get(position).getTitulo());

        return view;
    }




}

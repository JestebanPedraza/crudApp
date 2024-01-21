package com.pedraza.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {

    TextView edtitulo,edgenero,edanio;
    Button btnregistrar;
    private  int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);


        edtitulo=findViewById(R.id.edtitulo);
        edgenero=findViewById(R.id.edgenero);
        edanio=findViewById(R.id.edanio);



        Intent intent=getIntent();
        position=intent.getExtras().getInt("position");


        edtitulo.setText(MainActivity.juegosArrayList.get(position).getTitulo());
        edgenero.setText(MainActivity.juegosArrayList.get(position).getGenero());
        edanio.setText(MainActivity.juegosArrayList.get(position).getAnio());
    }
}
package com.pedraza.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Editar extends AppCompatActivity {

    EditText edtitulo,edgenero,edanio,edid;
    Button btnregistrar;
    private  int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);


        edid=findViewById(R.id.edid);
        edtitulo=findViewById(R.id.edtitulo);
        edgenero=findViewById(R.id.edgenero);
        edanio=findViewById(R.id.edanio);
        btnregistrar=findViewById(R.id.btneditar);


        Intent intent=getIntent();
        position=intent.getExtras().getInt("position");

        edid.setText(MainActivity.juegosArrayList.get(position).getId());
        edtitulo.setText(MainActivity.juegosArrayList.get(position).getTitulo());
        edgenero.setText(MainActivity.juegosArrayList.get(position).getGenero());
        edanio.setText(MainActivity.juegosArrayList.get(position).getAnio());


        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Actualizar();
            }
        });
    }

    private void Actualizar() {

        String id=edid.getText().toString().trim();
        String titulo=edtitulo.getText().toString().trim();
        String genero=edgenero.getText().toString().trim();
        String anio=edanio.getText().toString().trim();

        ProgressDialog progressDialog =new ProgressDialog(this);
        progressDialog.setMessage("Actualizando");


        if (titulo.isEmpty()){
            Toast.makeText(this,"ingrese titulo",Toast.LENGTH_SHORT).show();
        }else if (genero.isEmpty()){
            Toast.makeText(this,"ingrese género",Toast.LENGTH_SHORT).show();
        }else if (titulo.isEmpty()){
            Toast.makeText(this,"ingrese año",Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.show();
            StringRequest request =new StringRequest(Request.Method.POST, "http://172.20.10.4/web-service-php-master/actualizar_.php",
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(Editar.this, "actualizó correctamente", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Editar.this,error.getMessage(),Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
            ){

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String,String>params=new HashMap<>();
                    params.put("id",id);
                    params.put("titulo",titulo);
                    params.put("genero",genero);
                    params.put("anio",anio);

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Editar.this);
            requestQueue.add(request);
        }
    }
}
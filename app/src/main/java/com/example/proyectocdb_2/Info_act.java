package com.example.proyectocdb_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    // Intent Implicito
    public void Marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL); // accion para marcado telefonico
        i.setData(Uri.parse("tel:"+"956377339")); // colocamos el numero a marcar
        startActivity(i);
    }
    public void Maps(View view)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}
package com.example.proyectocdb_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.View;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vwvideo);

        //obtengo ruta del video
        String ruta ="android.resource://"+getPackageName()+"/"+R.raw.videocdb;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        video.start();
    }

    public void Insumos(View View)
    {
        //Preparo los extras
        Intent i = new Intent(this, Insumos_act.class);
        Bundle bun = new Bundle();//Necesario para enviar arreglos
        bun.putStringArray("insumos", in.getInsumos());//Relleno el bundle
        i.putExtras(bun);//Le paso el Bundle al Intent
        startActivity(i);
    }
}
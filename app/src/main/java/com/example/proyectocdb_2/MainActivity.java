package com.example.proyectocdb_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Objetos.Administrador;

public class MainActivity extends AppCompatActivity {

    private EditText usu, pass;
    private Button btnus;
    private Administrador adm = new Administrador();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usu = findViewById(R.id.etusu);
        pass = findViewById(R.id.etpass);
        btnus = findViewById(R.id.btnusu);

        btnus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Aqui voy a correr mi tarea
                new Task().execute();
            }
        });

    }

    class Task extends AsyncTask<String, Void, String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Intent i = new Intent(getBaseContext(), Carga_act.class);
            startActivity(i);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for(int i = 0; i <= 10; i++)
                {
                    Thread.sleep(300);//Duerme un proceso
                }
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            String usuario = usu.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            if (usuario.equals(userObj) && contrasena.equals(passObj))
            {
                Intent i = new Intent(getBaseContext(), Home_act.class);//Explicito
                startActivity(i);
            }

            else if (usuario.equals("") && contrasena.equals(""))
            {
                Toast.makeText(getBaseContext(), "Campos vacios porfavor intete nuevamente", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getBaseContext(), MainActivity.class);//Explicito
                startActivity(i);
            }

            else if (!usuario.equals(userObj) || !contrasena.equals(passObj))
            {
                Toast.makeText(getBaseContext(), "Campos incorrectos porfavor intente nuevamente", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getBaseContext(), MainActivity.class);//Explicito
                startActivity(i);
            }


        }

    }

    public void Facebook(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }
    public void Twitter(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }
    public void Youtube(View view)
    {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }

    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }
}
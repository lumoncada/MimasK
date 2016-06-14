package com.luisamoncada.miapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton bpeluqieria, bveterinaria, bpaseo, bhotel, bcomida, bfamilia, bconfig, bbuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bpeluqieria = (ImageButton) findViewById(R.id.bpeluqueria);
        bveterinaria = (ImageButton) findViewById(R.id.bveterinaria);
        bpaseo = (ImageButton) findViewById(R.id.bpaseo);
        bhotel = (ImageButton) findViewById(R.id.bhotel);
        bcomida = (ImageButton) findViewById(R.id.bcomida);
        bfamilia = (ImageButton) findViewById(R.id.bfamilia);
        bconfig = (ImageButton) findViewById(R.id.bconfig);
        bbuscar = (ImageButton) findViewById(R.id.bbuscar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getGroupId();

        if (id == R.id.menu_configurar) {
            Toast.makeText(this, "Presiono Configurar", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void AbrirPeluqueria(View view) {
        Intent i = new Intent(this, Apeluqueria.class);
        startActivity(i);
    }

    public void AbrirVeterinaria(View view) {
        Intent i = new Intent(this, Aveterinaria.class);
        startActivity(i);
    }

    public void AbrirPaseo(View view) {
        Intent i = new Intent(this, Apaseo.class);
        startActivity(i);
    }

    public void AbrirHotel(View view) {
        Intent i = new Intent(this, Ahotel.class);
        startActivity(i);
    }
    public void AbrirComida(View view) {
        Intent i = new Intent(this, Acomida.class);
        startActivity(i);
    }

    public void AbrirFamilia(View view) {
        Intent i = new Intent(this, Afamilia.class);
        startActivity(i);
    }

    public void AbrirBuscar(View view) {
        Intent i = new Intent(this, Abuscar.class);
        startActivity(i);
    }
    public void AbrirConfiguracion(View view) {
        Intent i = new Intent(this, Aconfiguracion.class);
        startActivity(i);
    }
}
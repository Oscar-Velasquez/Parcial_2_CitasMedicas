package com.upn.example.examenfinal_colorado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Button vercitas, formulario, sedes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vercitas();
        realizarformulario();
        versedes();

    }

    private void vercitas(){
        vercitas = findViewById(R.id.btncitas);
        vercitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListadodeCitas.class);
                startActivity(intent);
            }
        });
    }

    private void realizarformulario(){
        formulario = findViewById(R.id.btnformulario);
        formulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FormulariodeCitas.class);
                startActivity(intent);
            }
        });
    }
    private void versedes(){
        sedes = findViewById(R.id.btnsedes);
        sedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ubicaciones.class);
                startActivity(intent);
            }
        });
    }

}
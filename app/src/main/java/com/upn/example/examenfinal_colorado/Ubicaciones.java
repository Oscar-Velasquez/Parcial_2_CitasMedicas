package com.upn.example.examenfinal_colorado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ubicaciones extends AppCompatActivity {
    Button lamolina, sanisidro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicaciones);
        asignarubicaciones();
    }

    private void  asignarubicaciones(){
        lamolina = findViewById(R.id.btnlamolina);
        lamolina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ubicaciones.this, Mapas.class);
                intent.putExtra("latitud", "13.343251082738023");
                intent.putExtra("longitud", "-88.44985087371903");
                intent.putExtra("titulo", "Hospital San Pedro");
                startActivity(intent);

            }
        });

        sanisidro = findViewById(R.id.btnsanisidro);
        sanisidro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ubicaciones.this, Mapas.class);
                intent.putExtra("latitud", "13.347215398154267");
                intent.putExtra("longitud",  "-88.44293944302608");
                intent.putExtra("titulo", "Instituto Nacional del Seguro Social");
                startActivity(intent);

            }
        });

    }
}
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
                intent.putExtra("latitud", "-12.07391159151804");
                intent.putExtra("longitud", "-76.95602955772794");
                intent.putExtra("titulo", "Clinica Anglo Americana - Sede La Molina");
                startActivity(intent);

            }
        });

        sanisidro = findViewById(R.id.btnsanisidro);
        sanisidro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Ubicaciones.this, Mapas.class);
                intent.putExtra("latitud", "-12.108002429349295");
                intent.putExtra("longitud",  "-77.03900350993432");
                intent.putExtra("titulo", "Clinica Anglo Americana - Sede San Isidro");
                startActivity(intent);

            }
        });

    }
}
package com.upn.example.examenfinal_colorado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {
    TextView cargando;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_inicio);

        //animaciones
        Animation a1 = AnimationUtils.loadAnimation(this, R.anim.despla_arriba);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.despla_abajo);

        cargando = findViewById(R.id.txtcargando);
        logo = findViewById(R.id.idimagen);

        cargando.setAnimation(a2);
        logo.setAnimation(a1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Inicio.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}
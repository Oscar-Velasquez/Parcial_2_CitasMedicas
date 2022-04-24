package com.upn.example.examenfinal_colorado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.upn.example.examenfinal_colorado.Dao.CitasDao;
import com.upn.example.examenfinal_colorado.Entidad.Cita;

import java.util.ArrayList;
import java.util.List;

public class ListadodeCitas extends AppCompatActivity {
    RecyclerView recyclercitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listadode_citas);
        asignarreferencia();
        mostrardatos();
    }

    private  void asignarreferencia(){
        recyclercitas = findViewById(R.id.recyclercitas);
    }

    private  void mostrardatos(){
        List<Cita> listaCitas = new ArrayList<>();
        CitasDao citasDAO = new CitasDao(this);
        citasDAO.abrirBD();
        listaCitas = citasDAO.findAllCita();

        Adaptador adaptador = new Adaptador(this,listaCitas);
        recyclercitas.setAdapter(adaptador);
        recyclercitas.setLayoutManager(new LinearLayoutManager(this));
    }
}
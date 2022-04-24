package com.upn.example.examenfinal_colorado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Mapas extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;
    float latitud, longitud;
    String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        asignarRefe();

    }


    private void asignarRefe(){
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        map.getUiSettings().setZoomControlsEnabled(true);
        recuperarDatos();

        LatLng mapa = new LatLng(latitud, longitud);
        map.addMarker(new MarkerOptions().position(mapa).title(titulo));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(mapa,16));

    }

    private void recuperarDatos(){
            latitud = Float.parseFloat(getIntent().getStringExtra("latitud"));
            longitud = Float.parseFloat(getIntent().getStringExtra("longitud"));
            titulo = getIntent().getStringExtra("titulo");

    }

}
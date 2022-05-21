package com.upn.example.examenfinal_colorado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class menulateral extends AppCompatActivity {

    //Menu lateral
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menulateral);

        //Menu lateral
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.menu_Open, R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_menu:
                        Log.i("MENU_DRAWER_TAG","Menu item is clicked");
                        Intent menu = new Intent(menulateral.this,MainActivity.class);
                        startActivity(menu);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_ayuda:
                        Log.i("MENU_DRAWER_TAG", "Help item is clicked");
                        Intent ayuda = new Intent(menulateral.this,Ayuda.class);
                        startActivity(ayuda);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_acercade:
                        Log.i("MENU_DRAWER_TAG", "Info item is clicked");
                        Intent acercade = new Intent(menulateral.this,Acercade.class);
                        startActivity(acercade);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_doctores:
                        Log.i("MENU_DRAWER_TAG","Doctor item is clicked");
                        Intent doctor = new Intent(menulateral.this,Doctores.class);
                        startActivity(doctor);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
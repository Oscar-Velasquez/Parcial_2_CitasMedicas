package com.upn.example.examenfinal_colorado;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.upn.example.examenfinal_colorado.Dao.CitasDao;
import com.upn.example.examenfinal_colorado.Entidad.Cita;

public class FormulariodeCitas extends AppCompatActivity {
    EditText nombre, apellido, dni, especialidad, sede, turno, doctor;
    Button agregar;
    Boolean registrar = true;
    String txtnombre, txtapellido, txtdni, txtespe, txtsede, txtturno, txtdoc;
    int id, dnei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulariode_citas);
        referencias();
        validarcampos();
        recibirdatos();
    }

    private void recibirdatos(){
        if(getIntent().hasExtra("varid")){
            registrar = false;
            id = getIntent().getIntExtra("varid",0);
            txtnombre = getIntent().getStringExtra("varnombre");
            txtapellido = getIntent().getStringExtra("varapellido");
            dnei = getIntent().getIntExtra("vardni",0);
            txtespe = getIntent().getStringExtra("varespecialidad");
            txtsede = getIntent().getStringExtra("varsede");
            txtturno = getIntent().getStringExtra("varturno");
            txtdoc = getIntent().getStringExtra("vardoctor");

            nombre.setText(txtnombre);
            apellido.setText(txtapellido);
            dni.setText(txtdni+"");
            especialidad.setText(txtespe);
            sede.setText(txtsede);
            turno.setText(txtturno);
            doctor.setText(txtdoc);

        }
    }

    private void referencias(){
        nombre= findViewById(R.id.txtnombre);
        apellido= findViewById(R.id.txtapellido);
        dni=findViewById(R.id.txtdni);
        especialidad=findViewById(R.id.txtespe);
        sede=findViewById(R.id.txtsede);
        turno=findViewById(R.id.txtturno);
        doctor=findViewById(R.id.txtdoctor);
        agregar=findViewById(R.id.btnregistar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrarcita();
            }
        });
    }



    private boolean validarcampos(){
        String t1 = nombre.getText().toString();
        String t2 = apellido.getText().toString();
        String t3 = dni.getText().toString();
        String t4 = especialidad.getText().toString();
        String t5 = sede.getText().toString();
        String t6 = turno.getText().toString();
        String t7 = doctor.getText().toString();
        boolean vacio = true;

        if(t1.equals("")){
            nombre.setError("Nombre es Obligatorio");
            vacio = false;
        }

        if(t2.equals("")){
            apellido.setError("Apellido esObligatorio");
            vacio = false;
        }

        if(t3.equals("")){
            dni.setError("DNI es Obligatorio");
            vacio = false;
        }

        if(t4.equals("")){
            especialidad.setError("Especialidad es Obligatorio");
            vacio = false;
        }

        if(t5.equals("")){
            sede.setError("Sede es Obligatorio");
            vacio = false;
        }

        if(t5 != "San Isidro"){
            sede.setError("Las sedes disponibles son San Isidro y La Molina");
            vacio = false;

        }else if (t5 != "La Molina") {
            sede.setError("Las sedes disponibles son San Isidro y La Molina");
            vacio = false;

        }else{
            vacio = true;
        }

        if(t6.equals("")){
            turno.setError("Turno es Obligatorio");
            vacio = false;
        }

        if(t7.equals("")){
            doctor.setError("Doctor es Obligatorio");
            vacio = false;
        }

        return vacio;
    }

    private void registrarcita(){
        String nom, ape, espe, sed, tur, doc;
        int dn;
        nom = nombre.getText().toString();
        ape = apellido.getText().toString();
        dn = Integer.parseInt(dni.getText().toString());
        espe = especialidad.getText().toString();
        sed = sede.getText().toString();
        tur = turno.getText().toString();
        doc = doctor.getText().toString();

        CitasDao citasDAO = new CitasDao(this);
        citasDAO.abrirBD();
        String mensaje;

        if(registrar == true){
            Cita cita = new Cita(nom,ape, dn, espe, sed, tur, doc);
            mensaje = citasDAO.registrarcita(cita);
        }else{
            Cita cita = new Cita(id, nom, ape, dn, espe, sed, tur, doc);
            mensaje = citasDAO.editarcita(cita);
        }

        AlertDialog.Builder ventana = new AlertDialog.Builder(FormulariodeCitas.this);
        ventana.setTitle("Mensaje info");
        ventana.setMessage(mensaje);
        ventana.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(FormulariodeCitas.this, ListadodeCitas.class);
                startActivity(intent);
            }
        });
        ventana.create().show();
    }



}
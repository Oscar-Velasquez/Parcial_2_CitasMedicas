package com.upn.example.examenfinal_colorado.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.upn.example.examenfinal_colorado.Entidad.Cita;
import com.upn.example.examenfinal_colorado.Utilidad.CitasBD;
import com.upn.example.examenfinal_colorado.Utilidad.Constante;

import java.util.ArrayList;
import java.util.List;

public class CitasDao {
    private static CitasBD citasBD;
    private static SQLiteDatabase db;
    private Context context;

    public CitasDao(Context context){
        citasBD = new CitasBD(context);
        this.context = context;
    }

    public static void abrirBD(){
        db = citasBD.getWritableDatabase();
    }

    public static String registrarcita(Cita cita){
        String mensaje = "";
        try {
            ContentValues valores = new ContentValues();
            valores.put("nombre", cita.getNombre());
            valores.put("apellido", cita.getApellido());
            valores.put("dni", cita.getDni());
            valores.put("especialidad", cita.getEspecialidad());
            valores.put("sede", cita.getSede());
            valores.put("turno", cita.getTurno());
            valores.put("doctor", cita.getDoctor());

            long resultado = db.insert(Constante.NOMBRE_TABLA,null,valores);
            if(resultado == -1){
                mensaje = "ERROR AL AGREGAR";
            }else{
                mensaje = "SE AGREGO CORRECTAMENTE";
            }


        }catch (Exception e){
            mensaje = e.getMessage();
        }
        return mensaje;
    }

    public List<Cita> findAllCita(){
        List<Cita> listaCita = new ArrayList<>();
        try {
            Cursor c = db.rawQuery("SELECT * FROM "+Constante.NOMBRE_TABLA,null);
            while(c.moveToNext()){
                listaCita.add(new Cita(
                        c.getInt(0),
                        c.getString(1),
                        c.getString(2),
                        c.getInt(3),
                        c.getString(4),
                        c.getString(5),
                        c.getString(6),
                        c.getString(7)

                ));
            }
        }catch (Exception e){
            Log.d("=>",e.getMessage());

        }
        return listaCita;
    }


    public String  editarcita(Cita cita){
        String mensaje = "";
        try {
            ContentValues valores = new ContentValues();
            valores.put("nombre",cita.getNombre());
            valores.put("apellido",cita.getApellido());
            valores.put("dni", cita.getDni());
            valores.put("especialidad", cita.getEspecialidad());
            valores.put("sede", cita.getSede());
            valores.put("turno", cita.getTurno());
            valores.put("doctor", cita.getDoctor());
            long resultado = db.update(Constante.NOMBRE_TABLA, valores,"id="+cita.getId(),null);
            if(resultado==-1){
                mensaje = "Error";
            }else{
                mensaje ="Se actualizo";
            }
        }catch (Exception e){
            mensaje = e.getMessage();
        }

        return mensaje;
    }

    public String borrarRegistro(int id){
        String mensaje = "";
        try{
            long resultado = db.delete(Constante.NOMBRE_TABLA,"id="+id,null);
            if(resultado == -1){
                mensaje = "Error al borrar";

            }else{
                mensaje = "Registro borrado";
            }

        }catch (Exception e){
            mensaje = e.getMessage();

        }
        return mensaje;

    }

}

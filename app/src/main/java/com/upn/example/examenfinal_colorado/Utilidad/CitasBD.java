package com.upn.example.examenfinal_colorado.Utilidad;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CitasBD extends SQLiteOpenHelper {

    public CitasBD(Context context){
        super(context, Constante.NOMBRE_BD,null,Constante.VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE "+Constante.NOMBRE_TABLA+
                        " (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        " nombre TEXT NOT NULL,"+
                        " apellido TEXT NOT NULL,"+
                        " dni INTEGER NOT NULL,"+
                        " especialidad TEXT NOT NULL,"+
                        " sede TEXT NOT NULL,"+
                        " turno TEXT NOT NULL,"+
                        " doctor TEXT NOT NULL);";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

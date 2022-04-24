package com.upn.example.examenfinal_colorado;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upn.example.examenfinal_colorado.Dao.CitasDao;
import com.upn.example.examenfinal_colorado.Entidad.Cita;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder>{

    private Context context;
    private List<Cita> listaCita = new ArrayList<>();

    public Adaptador(Context context, List<Cita> listaMatricula){
        this.context = context;
        this.listaCita= listaMatricula;
    }


    @NonNull
    @Override
    public Adaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View vista = inflater.inflate(R.layout.filacita,parent,false);
        return new MyViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.MyViewHolder holder, int position) {
        holder.fila_nombre.setText(listaCita.get(position).getNombre()+"");
        holder.fila_apellido.setText(listaCita.get(position).getApellido()+"");
        holder.fila_dni.setText(listaCita.get(position).getDni()+"");
        holder.fila_espe.setText(listaCita.get(position).getEspecialidad()+"");
        holder.fila_sede.setText(listaCita.get(position).getSede()+"");
        holder.fila_turn.setText(listaCita.get(position).getTurno()+"");
        holder.fila_doc.setText(listaCita.get(position).getDoctor()+"");

        holder.btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FormulariodeCitas.class);
                intent.putExtra("varid",listaCita.get(position).getId());
                intent.putExtra("varnombre",listaCita.get(position).getNombre());
                intent.putExtra("varapellido",listaCita.get(position).getApellido());
                intent.putExtra("vardni",listaCita.get(position).getDni()+"");
                intent.putExtra("varespecialidad",listaCita.get(position).getEspecialidad());
                intent.putExtra("varsede",listaCita.get(position).getSede());
                intent.putExtra("varturno",listaCita.get(position).getTurno());
                intent.putExtra("vardoctor",listaCita.get(position).getDoctor());

                context.startActivity(intent);

            }
        });

        holder.btnborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder ventana = new AlertDialog.Builder(context);
                ventana.setTitle("Borrar:");
                ventana.setMessage("¿Quiere borrar el siguiente registro:" +listaCita.get(position).getId()+"?");
                ventana.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        CitasDao dao = new CitasDao(context);
                        dao.abrirBD();
                        String mensaje = dao.borrarRegistro(listaCita.get(position).getId());
                        AlertDialog.Builder v = new AlertDialog.Builder(context);
                        v.setTitle("Mensaje Informativo");
                        v.setMessage(mensaje);
                        v.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(context, MainActivity.class);
                                context.startActivity(intent);

                            }
                        });
                        v.create().show();

                    }
                });
                ventana.setNegativeButton("CANCELAR",null);
                ventana.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaCita.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView fila_nombre,fila_apellido,fila_dni,fila_espe,fila_sede,fila_turn,fila_doc;
        ImageButton btneditar , btnborrar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            fila_nombre = itemView.findViewById(R.id.fila_nombre);
            fila_apellido = itemView.findViewById(R.id.fila_apellido);
            fila_dni = itemView.findViewById(R.id.fila_dni);
            fila_espe = itemView.findViewById(R.id.fila_espe);
            fila_sede = itemView.findViewById(R.id.fila_sede);
            fila_turn = itemView.findViewById(R.id.fila_turno);
            fila_doc = itemView.findViewById(R.id.fila_doc);
            btneditar = itemView.findViewById(R.id.btn_editar);
            btnborrar = itemView.findViewById(R.id.btn_eliminar);

        }
    }

}

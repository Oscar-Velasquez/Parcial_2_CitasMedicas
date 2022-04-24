package com.upn.example.examenfinal_colorado.Entidad;

public class Cita {
    private int id;
    private String nombre;
    private String apellido;
    private int dni;
    private String especialidad;
    private String sede;
    private String turno;
    private String doctor;


    public Cita(String nombre, String apellido, int dni, String especialidad, String sede, String turno, String doctor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.especialidad = especialidad;
        this.sede = sede;
        this.turno = turno;
        this.doctor = doctor;
    }

    public Cita(int id, String nombre, String apellido, int dni, String especialidad, String sede, String turno, String doctor) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.especialidad = especialidad;
        this.sede = sede;
        this.turno = turno;
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }


}

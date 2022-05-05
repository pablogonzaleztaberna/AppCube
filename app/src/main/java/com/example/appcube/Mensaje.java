package com.example.appcube;

public class Mensaje {

    private String nombre;
    private String mensaje;
    private String hora;
    private String numMensajes;

    public Mensaje() {
    }

    public Mensaje(String nombre, String mensaje, String hora, String numMensajes) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.hora = hora;
        this.numMensajes = numMensajes;
    }

    public Mensaje(String nombre, String mensaje, String hora) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNumMensajes() {
        return numMensajes;
    }

    public void setNumMensajes(String numMensajes) {
        this.numMensajes = numMensajes;
    }
}

package com.example.appcube;

public class Mensaje {

    private int foto;
    private String nombre;
    private String mensaje;
    private String hora;
    private String numMensajes;

    public Mensaje() {
    }

    public Mensaje(int foto, String nombre, String mensaje, String hora, String numMensajes) {
        this.foto = foto;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.hora = hora;
        this.numMensajes = numMensajes;
    }

    public Mensaje(int foto, String nombre, String mensaje, String hora) {
        this.foto = foto;
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.hora = hora;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
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

package com.example.appcube;

public class Amigo {

    private String nombre;
    private String mensaje;
    private String boton;
    private int foto;

    public Amigo() {}

    public Amigo(String nombre, String mensaje, String boton, int foto) {
        this.nombre = nombre;
        this.mensaje = mensaje;
        this.boton = boton;
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

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
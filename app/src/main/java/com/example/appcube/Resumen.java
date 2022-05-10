package com.example.appcube;

public class Resumen {

    private int historia, foto;
    private String aviso, nombre;

    public Resumen() {
    }

    public Resumen(int historia, int foto, String aviso, String nombre) {
        this.historia = historia;
        this.foto = foto;
        this.aviso = aviso;
        this.nombre = nombre;
    }

    public Resumen(int historia, int foto, String nombre) {
        this.historia = historia;
        this.foto = foto;
        this.nombre = nombre;
    }

    public Resumen(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public Resumen(int historia, String aviso, String nombre) {
        this.historia = historia;
        this.aviso = aviso;
        this.nombre = nombre;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getAviso() {
        return aviso;
    }

    public void setAviso(String aviso) {
        this.aviso = aviso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

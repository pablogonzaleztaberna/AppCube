package com.example.appcube;

public class Publicacion {

    private int fotoPerfil, fotoPost;
    private String nombre, titulo;

    public Publicacion() {
    }

    public Publicacion(int fotoPerfil, int fotoPost, String nombre, String titulo) {
        this.fotoPerfil = fotoPerfil;
        this.fotoPost = fotoPost;
        this.nombre = nombre;
        this.titulo = titulo;
    }

    public int getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(int fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public int getFotoPost() {
        return fotoPost;
    }

    public void setFotoPost(int fotoPost) {
        this.fotoPost = fotoPost;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}

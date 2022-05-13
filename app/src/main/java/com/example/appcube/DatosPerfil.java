package com.example.appcube;

public class DatosPerfil {
    private String numPublicaciones, numSeguidores, numComentarios, numGustos;
    private String descripcion;
    private int foto1, foto2, foto3, foto4, foto5, foto6, foto7, foto8;

    public DatosPerfil() {
    }

    public DatosPerfil(String numPublicaciones, String numSeguidores, String numComentarios, String numGustos, String descripcion, int foto1, int foto2, int foto3, int foto4, int foto5, int foto6, int foto7, int foto8) {
        this.numPublicaciones = numPublicaciones;
        this.numSeguidores = numSeguidores;
        this.numComentarios = numComentarios;
        this.numGustos = numGustos;
        this.descripcion = descripcion;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
        this.foto6 = foto6;
        this.foto7 = foto7;
        this.foto8 = foto8;
    }

    public String getNumPublicaciones() {
        return numPublicaciones;
    }

    public void setNumPublicaciones(String numPublicaciones) {
        this.numPublicaciones = numPublicaciones;
    }

    public String getNumSeguidores() {
        return numSeguidores;
    }

    public void setNumSeguidores(String numSeguidores) {
        this.numSeguidores = numSeguidores;
    }

    public String getNumComentarios() {
        return numComentarios;
    }

    public void setNumComentarios(String numComentarios) {
        this.numComentarios = numComentarios;
    }

    public String getNumGustos() {
        return numGustos;
    }

    public void setNumGustos(String numGustos) {
        this.numGustos = numGustos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto1() {
        return foto1;
    }

    public void setFoto1(int foto1) {
        this.foto1 = foto1;
    }

    public int getFoto2() {
        return foto2;
    }

    public void setFoto2(int foto2) {
        this.foto2 = foto2;
    }

    public int getFoto3() {
        return foto3;
    }

    public void setFoto3(int foto3) {
        this.foto3 = foto3;
    }

    public int getFoto4() {
        return foto4;
    }

    public void setFoto4(int foto4) {
        this.foto4 = foto4;
    }

    public int getFoto5() {
        return foto5;
    }

    public void setFoto5(int foto5) {
        this.foto5 = foto5;
    }

    public int getFoto6() {
        return foto6;
    }

    public void setFoto6(int foto6) {
        this.foto6 = foto6;
    }

    public int getFoto7() {
        return foto7;
    }

    public void setFoto7(int foto7) {
        this.foto7 = foto7;
    }

    public int getFoto8() {
        return foto8;
    }

    public void setFoto8(int foto8) {
        this.foto8 = foto8;
    }
}

package com.example.appcube;

public class InfoPerfil {

    private int fotoPerfil;
    private String nombreUsuario, idUsuario;

    public InfoPerfil() {
    }

    public InfoPerfil(int fotoPerfil, String nombreUsuario, String idUsuario) {
        this.fotoPerfil = fotoPerfil;
        this.nombreUsuario = nombreUsuario;
        this.idUsuario = idUsuario;
    }

    public int getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(int fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
}

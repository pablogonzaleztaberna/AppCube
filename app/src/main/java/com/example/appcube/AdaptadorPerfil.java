package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPerfil extends RecyclerView.Adapter<AdaptadorPerfil.PerfilViewHolder> {

    ArrayList<PublicacionPerfil> listaPublicacionesPerfil;

    public AdaptadorPerfil(ArrayList<PublicacionPerfil> listaPublicacionesPerfil) {
        this.listaPublicacionesPerfil = listaPublicacionesPerfil;
    }

    @NonNull
    @Override
    public AdaptadorPerfil.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_info_perfil, null, false);
        return new AdaptadorPerfil.PerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPerfil.PerfilViewHolder holder, int position) {
        holder.fotoPerfil.setImageResource(listaPublicacionesPerfil.get(position).getFotoPerfil());
        holder.fotoPost.setImageResource(listaPublicacionesPerfil.get(position).getFotoPost());
        holder.nombre.setText(listaPublicacionesPerfil.get(position).getNombre());
        holder.titulo.setText(listaPublicacionesPerfil.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return listaPublicacionesPerfil.size();
    }

    public class PerfilViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoPerfil, fotoPost;
        TextView nombre, titulo;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoPerfil = (ImageView) itemView.findViewById(R.id.imgvPerfil);
            fotoPost = (ImageView) itemView.findViewById(R.id.imgvPost);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
        }
    }
}

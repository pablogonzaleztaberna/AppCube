package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPublicacion extends RecyclerView.Adapter<AdaptadorPublicacion.PublicacionViewHolder> {

    ArrayList<Publicacion> listaPublicaciones;

    public AdaptadorPublicacion(ArrayList<Publicacion> listaPublicaciones) {
        this.listaPublicaciones = listaPublicaciones;
    }

    @NonNull
    @Override
    public AdaptadorPublicacion.PublicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_publicaciones, null, false);
        return new PublicacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPublicacion.PublicacionViewHolder holder, int position) {
        holder.fotoPerfil.setImageResource(listaPublicaciones.get(position).getFotoPerfil());
        holder.fotoPost.setImageResource(listaPublicaciones.get(position).getFotoPost());
        holder.nombre.setText(listaPublicaciones.get(position).getNombre());
        holder.titulo.setText(listaPublicaciones.get(position).getTitulo());
    }

    @Override
    public int getItemCount() {
        return listaPublicaciones.size();
    }

    public class PublicacionViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoPerfil, fotoPost;
        TextView nombre, titulo;

        public PublicacionViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoPerfil = (ImageView) itemView.findViewById(R.id.imgvPerfil);
            fotoPost = (ImageView) itemView.findViewById(R.id.imgvPost);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            titulo = (TextView) itemView.findViewById(R.id.titulo);
        }
    }
}


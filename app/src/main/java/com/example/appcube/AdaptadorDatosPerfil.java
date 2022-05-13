package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorDatosPerfil extends RecyclerView.Adapter<AdaptadorDatosPerfil.DatosPerfilViewHolder> {

    ArrayList<DatosPerfil> listaDatosPerfil;

    public AdaptadorDatosPerfil(ArrayList<DatosPerfil> listaDatosPerfil) {
        this.listaDatosPerfil = listaDatosPerfil;
    }

    @NonNull
    @Override
    public AdaptadorDatosPerfil.DatosPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_datos_perfil, null, false);
        return new AdaptadorDatosPerfil.DatosPerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorDatosPerfil.DatosPerfilViewHolder holder, int position) {
        holder.numPublicaciones.setText(listaDatosPerfil.get(position).getNumPublicaciones());
        holder.numSeguidores.setText(listaDatosPerfil.get(position).getNumSeguidores());
        holder.numComentarios.setText(listaDatosPerfil.get(position).getNumComentarios());
        holder.numGustos.setText(listaDatosPerfil.get(position).getNumGustos());
        holder.descripcion.setText(listaDatosPerfil.get(position).getDescripcion());
        holder.foto1.setImageResource(listaDatosPerfil.get(position).getFoto1());
        holder.foto2.setImageResource(listaDatosPerfil.get(position).getFoto2());
        holder.foto3.setImageResource(listaDatosPerfil.get(position).getFoto3());
        holder.foto4.setImageResource(listaDatosPerfil.get(position).getFoto4());
        holder.foto5.setImageResource(listaDatosPerfil.get(position).getFoto5());
        holder.foto6.setImageResource(listaDatosPerfil.get(position).getFoto6());
        holder.foto7.setImageResource(listaDatosPerfil.get(position).getFoto7());
        holder.foto8.setImageResource(listaDatosPerfil.get(position).getFoto8());
    }

    @Override
    public int getItemCount() {
        return listaDatosPerfil.size();
    }

    public class DatosPerfilViewHolder extends RecyclerView.ViewHolder {

        TextView numPublicaciones, numSeguidores, numComentarios, numGustos, descripcion;
        ImageView foto1, foto2, foto3, foto4, foto5, foto6, foto7, foto8;

        public DatosPerfilViewHolder(@NonNull View itemView) {
            super(itemView);

            numPublicaciones = (TextView) itemView.findViewById(R.id.numPublicaciones);
            numSeguidores = (TextView) itemView.findViewById(R.id.numSeguidores);
            numComentarios = (TextView) itemView.findViewById(R.id.numComentarios);
            numGustos = (TextView) itemView.findViewById(R.id.numGustos);
            descripcion = (TextView) itemView.findViewById(R.id.descripcion);
            foto1 = (ImageView) itemView.findViewById(R.id.foto1);
            foto2 = (ImageView) itemView.findViewById(R.id.foto2);
            foto3 = (ImageView) itemView.findViewById(R.id.foto3);
            foto4 = (ImageView) itemView.findViewById(R.id.foto4);
            foto5 = (ImageView) itemView.findViewById(R.id.foto5);
            foto6 = (ImageView) itemView.findViewById(R.id.foto6);
            foto7 = (ImageView) itemView.findViewById(R.id.foto7);
            foto8 = (ImageView) itemView.findViewById(R.id.foto8);
        }
    }
}
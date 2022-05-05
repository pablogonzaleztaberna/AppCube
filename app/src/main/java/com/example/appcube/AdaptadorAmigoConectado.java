package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorAmigoConectado extends RecyclerView.Adapter<AdaptadorAmigoConectado.AmigoConectadoViewHolder> {

    ArrayList<AmigoConectado> listaAmigosConectados;

    public AdaptadorAmigoConectado(ArrayList<AmigoConectado> listaAmigosConectados) {
        this.listaAmigosConectados = listaAmigosConectados;
    }

    @NonNull
    @Override
    public AdaptadorAmigoConectado.AmigoConectadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_amigos_conectados, null, false);
        return new AmigoConectadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorAmigoConectado.AmigoConectadoViewHolder holder, int position) {
        holder.foto.setImageResource(listaAmigosConectados.get(position).getFoto());
        holder.nombre.setText(listaAmigosConectados.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaAmigosConectados.size();
    }

    public class AmigoConectadoViewHolder extends RecyclerView.ViewHolder {

        ImageView foto;
        TextView nombre;

        public AmigoConectadoViewHolder(@NonNull View itemView) {
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.imgv);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
        }
    }
}
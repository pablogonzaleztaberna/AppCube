package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorResumen extends RecyclerView.Adapter<AdaptadorResumen.ResumenViewHolder> {

    ArrayList<Resumen> listaResumenes;

    public AdaptadorResumen(ArrayList<Resumen> listaResumenes) {
        this.listaResumenes = listaResumenes;
    }

    @NonNull
    @Override
    public AdaptadorResumen.ResumenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_resumenes, null, false);
        return new ResumenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorResumen.ResumenViewHolder holder, int position) {
        holder.historia.setImageResource(listaResumenes.get(position).getHistoria());
        //holder.aviso.setText(listaResumenes.get(position).getAviso());
        holder.foto.setImageResource(listaResumenes.get(position).getFoto());
        holder.nombre.setText(listaResumenes.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaResumenes.size();
    }

    public class ResumenViewHolder extends RecyclerView.ViewHolder {

        ImageView foto, historia;
        TextView nombre;

        public ResumenViewHolder(@NonNull View itemView) {
            super(itemView);

            historia = (ImageView) itemView.findViewById(R.id.imgvHistoria);
            //aviso = (TextView) itemView.findViewById(R.id.enVivo);
            foto = (ImageView) itemView.findViewById(R.id.imgv);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
        }
    }
}

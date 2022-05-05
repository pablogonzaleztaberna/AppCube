package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorMensaje extends RecyclerView.Adapter<AdaptadorMensaje.MensajeViewHolder> {

    ArrayList<Mensaje> listaMensajes;

    public AdaptadorMensaje(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    @NonNull
    @Override
    public AdaptadorMensaje.MensajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_mensajes, null, false);
        return new MensajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMensaje.MensajeViewHolder holder, int position) {
        holder.nombre.setText(listaMensajes.get(position).getNombre());
        holder.mensaje.setText(listaMensajes.get(position).getMensaje());
        holder.hora.setText(listaMensajes.get(position).getHora());
        holder.numMensajes.setText(listaMensajes.get(position).getNumMensajes());
    }

    @Override
    public int getItemCount() {
        return listaMensajes.size();
    }

    public class MensajeViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, mensaje, hora, numMensajes;

        public MensajeViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.nombre);
            mensaje = (TextView) itemView.findViewById(R.id.mensaje);
            hora = (TextView) itemView.findViewById(R.id.hora);
            numMensajes = (TextView) itemView.findViewById(R.id.numMensajes);
        }
    }
}


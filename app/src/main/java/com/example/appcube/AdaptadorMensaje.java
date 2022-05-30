package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorMensaje extends RecyclerView.Adapter<AdaptadorMensaje.MensajeViewHolder> {

    ArrayList<Mensaje> listaMensajes;
    ArrayList<Mensaje> listaOriginal;

    public AdaptadorMensaje(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaMensajes);
    }

    @NonNull
    @Override
    public AdaptadorMensaje.MensajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_mensajes, null, false);
        return new MensajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorMensaje.MensajeViewHolder holder, int position) {
        holder.foto.setImageResource(listaMensajes.get(position).getFoto());
        holder.nombre.setText(listaMensajes.get(position).getNombre());
        holder.mensaje.setText(listaMensajes.get(position).getMensaje());
        holder.hora.setText(listaMensajes.get(position).getHora());
        holder.numMensajes.setText(listaMensajes.get(position).getNumMensajes());
    }

    public void filtrar(String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaMensajes.clear();
            listaMensajes.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Mensaje> coleccion = listaMensajes.stream().filter(i -> i.getNombre().toLowerCase()
                        .contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                listaMensajes.clear();
                listaMensajes.addAll(coleccion);
            } else {
                for (Mensaje mensaje : listaOriginal) {
                    if (mensaje.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaMensajes.clear();
                        listaMensajes.add(mensaje);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaMensajes.size();
    }

    public class MensajeViewHolder extends RecyclerView.ViewHolder {

        ImageView foto;
        TextView nombre, mensaje, hora, numMensajes;

        public MensajeViewHolder(@NonNull View itemView) {
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.imgv);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            mensaje = (TextView) itemView.findViewById(R.id.mensaje);
            hora = (TextView) itemView.findViewById(R.id.hora);
            numMensajes = (TextView) itemView.findViewById(R.id.numMensajes);
        }
    }
}


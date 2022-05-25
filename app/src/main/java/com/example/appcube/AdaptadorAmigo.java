package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorAmigo extends RecyclerView.Adapter<AdaptadorAmigo.AmigoViewHolder> {

    ArrayList<Amigo> listaAmigos;
    ArrayList<Amigo> listaOriginal;

    public AdaptadorAmigo(ArrayList<Amigo> listaAmigos) {
        this.listaAmigos = listaAmigos;
        listaOriginal = new ArrayList<>();
        listaOriginal.addAll(listaAmigos);
    }

    @NonNull
    @Override
    public AdaptadorAmigo.AmigoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_amigos, null, false);
        return new AmigoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorAmigo.AmigoViewHolder holder, int position) {
        holder.nombre.setText(listaAmigos.get(position).getNombre());
        holder.mensaje.setText(listaAmigos.get(position).getMensaje());
        holder.boton.setText(listaAmigos.get(position).getBoton());
        holder.foto.setImageResource(listaAmigos.get(position).getFoto());
    }

    public void filtrar(String txtBuscar) {
        int longitud = txtBuscar.length();
        if (longitud == 0) {
            listaAmigos.clear();
            listaAmigos.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Amigo> coleccion = listaAmigos.stream().filter(i -> i.getNombre().toLowerCase()
                .contains(txtBuscar.toLowerCase())).collect(Collectors.toList());
                listaAmigos.clear();
                listaAmigos.addAll(coleccion);
            } else {
                for (Amigo amigo : listaOriginal) {
                    if (amigo.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())) {
                        listaAmigos.clear();
                        listaAmigos.add(amigo);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaAmigos.size();
    }

    public class AmigoViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, mensaje;
        Button boton;
        ImageView foto;

        public AmigoViewHolder(@NonNull View itemView) {
            super(itemView);

            nombre = (TextView) itemView.findViewById(R.id.nombre);
            mensaje = (TextView) itemView.findViewById(R.id.mensaje);
            boton = (Button) itemView.findViewById(R.id.btnSeguir);
            foto = (ImageView) itemView.findViewById(R.id.imgv);
        }
    }
}
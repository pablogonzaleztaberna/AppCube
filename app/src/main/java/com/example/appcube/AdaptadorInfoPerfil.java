package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorInfoPerfil extends RecyclerView.Adapter<AdaptadorInfoPerfil.InfoPerfilViewHolder> {

    ArrayList<InfoPerfil> listaInfoPerfil;

    public AdaptadorInfoPerfil(ArrayList<InfoPerfil> listaInfoPerfil) {
        this.listaInfoPerfil = listaInfoPerfil;
    }

    @NonNull
    @Override
    public AdaptadorInfoPerfil.InfoPerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_info_perfil, null, false);
        return new AdaptadorInfoPerfil.InfoPerfilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorInfoPerfil.InfoPerfilViewHolder holder, int position) {
        holder.fotoPerfil.setImageResource(listaInfoPerfil.get(position).getFotoPerfil());
        holder.nombreUsuario.setText(listaInfoPerfil.get(position).getNombreUsuario());
        holder.idUsuario.setText(listaInfoPerfil.get(position).getIdUsuario());
    }

    @Override
    public int getItemCount() {
        return listaInfoPerfil.size();
    }

    public class InfoPerfilViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoPerfil;
        TextView nombreUsuario, idUsuario;

        public InfoPerfilViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoPerfil = (ImageView) itemView.findViewById(R.id.fotoPerfil);
            nombreUsuario = (TextView) itemView.findViewById(R.id.nombreUsuario);
            idUsuario = (TextView) itemView.findViewById(R.id.idUsuario);
        }
    }
}

package com.example.appcube;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {

    private int[] imagenes;

    public ViewPagerAdapter(int[] imagenes) {
        this.imagenes = imagenes;
    }

    public class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        ImageView imgV;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);

            imgV = itemView.findViewById(R.id.idImage);
        }
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        int img = imagenes[position];
        holder.imgV.setImageResource(img);
    }

    @Override
    public int getItemCount() {
        return imagenes.length;
    }

}

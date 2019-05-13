package com.example.axelh.tpposta;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{

    TextView titulo;
    TextView descripcion;
    ImageView imagen;
    int position;
    onClickNoticia listener;



    public MyViewHolder(@NonNull View itemView,onClickNoticia listener)
    {
        super(itemView);
        titulo=itemView.findViewById(R.id.titulo);
        descripcion=itemView.findViewById(R.id.descripcion);
        imagen=itemView.findViewById(R.id.imagen);
        this.listener=listener;
        itemView.setOnClickListener(this);



    }

    public void setPosition(int position)
    {
        this.position=position;
    }

    @Override
    public void onClick(View v)
    {
        this.listener.onClick(position);
    }
}

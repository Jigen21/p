package com.example.axelh.tpposta;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{

    List<Noticia> noticias;
    onClickNoticia listener;

    public MyAdapter(List<Noticia> noticias,onClickNoticia listener)
    {
        this.noticias = noticias;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.noticias,viewGroup,false);

        MyViewHolder myViewHolder = new MyViewHolder(v,listener);

        return myViewHolder;




    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i)
    {
        Noticia p = this.noticias.get(i);
        myViewHolder.titulo.setText(p.getTitulo());
        myViewHolder.descripcion.setText(p.getDescripcion());
        myViewHolder.imagen.setImageBitmap(BitmapFactory.decodeByteArray(p.getDatosimagen(),0,p.getDatosimagen().length));
        myViewHolder.setPosition(i);


    }

    @Override
    public int getItemCount()
    {
        return this.noticias.size();
    }


    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }
}

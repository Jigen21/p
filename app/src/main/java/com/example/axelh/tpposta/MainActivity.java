package com.example.axelh.tpposta;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback , onClickNoticia
{

    MyAdapter adapter;
    List<Noticia> noticias = new ArrayList<Noticia>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Noticia n = new Noticia();
        //noticias.add(n);
        //noticias.add(n);


        RecyclerView rv = (RecyclerView)findViewById(R.id.noticias);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new MyAdapter(noticias,this);
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(adapter);

        Handler h =new Handler(this);
        //MyThread mt = new MyThread("https://www.lapoliticaonline.com/files/rss/ultimasnoticias.xml",h);
        MyThread mt = new MyThread("https://www.telam.com.ar/rss2/sociedad.xml",h);
        mt.start();








    }

    @Override
    public boolean handleMessage(Message msg)
    {
        this.noticias=(List<Noticia>)msg.obj;
        adapter.setNoticias(this.noticias);
        adapter.notifyDataSetChanged();



       return true;
    }

    @Override
    public void onClick(int position)
    {
        Log.d("Click","JEJE");
        Log.d("CLIC",this.noticias.get(position).getTitulo());
        Intent a = new Intent(getBaseContext(),ActivityDos.class);
        a.putExtra("pagina",this.noticias.get(position).getLinkpagina());
        startActivity(a);



    }
}

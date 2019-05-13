package com.example.axelh.tpposta;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
//import android.widget.SearchView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback , onClickNoticia , SearchView.OnQueryTextListener
{

    MyAdapter adapter;
    List<Noticia> noticias = new ArrayList<Noticia>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.example_menu, menu);
        SearchView sv = (SearchView) menu.findItem(R.id.action_search).getActionView();
        sv.setOnQueryTextListener(this);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        //el cambio
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

    @Override
    public boolean onQueryTextSubmit(String s) {
        Log.d("TextSubmit", s);
        this.adapter.filter(s);
        /*this.noticias = this.myAdapter.getNoticias();
        List<Noticia> noticiasFiltro = new ArrayList<>();
        for (Noticia n : noticias) {
            if(n.getTitulo().equalsIgnoreCase(query)) {
                noticiasFiltro.add(n);
            }
        }
        this.myAdapter.setNoticias(noticiasFiltro);
        this.myAdapter.notifyDataSetChanged();*/
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        this.adapter.filter(newText);
        //Se puede usar un pattern en Java o un indexOf para buscar coincidencias. Lo que se busca en el search, debe coincidir con el titulo de la noticia.
        Log.d("TextChange", newText);
        return false;
    }




}

package com.example.axelh.tpposta;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ActivityDos extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina);

        final String s = getIntent().getStringExtra("pagina");

        WebView web = (WebView)findViewById(R.id.web);
        //web.getSettings().setJavaScriptEnabled(true);
        //setContentView(web);
        Log.d("Pagina",s);
        web.loadUrl("https://www.telam.com.ar"+s);

        Button compartir = (Button)findViewById(R.id.compartir);
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                myIntent.putExtra(Intent.EXTRA_TEXT,s);
                String shareBody ="body";
                String shareSub = "sub";
              //  startActivity(Intent.createChooser(myIntent),"Compartir Usando");
                startActivity(myIntent);
            }
        });


    }


}
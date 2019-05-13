package com.example.axelh.tpposta;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.webkit.WebView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ActivityDos extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagina);

        String s = getIntent().getStringExtra("pagina");

        WebView web = (WebView)findViewById(R.id.web);
        //web.getSettings().setJavaScriptEnabled(true);
        //setContentView(web);
        Log.d("Pagina",s);
        web.loadUrl("https://www.telam.com.ar"+s);


    }


}
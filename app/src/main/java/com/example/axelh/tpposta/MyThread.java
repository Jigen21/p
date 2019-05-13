package com.example.axelh.tpposta;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.text.ParseException;

class MyThread extends Thread
{

    String url;
    Handler h;

    public MyThread(String url,Handler h)
    {
        this.url = url;
        this.h=h;
    }

    public void run()
    {

        Message m = new Message();

        try {
            String s = MiConnec.traerNoticia(url);
            m.obj = XmlParser.traerNoticias(s);
            Log.d("ESTO",s);
            Log.d("OTRO",m.obj.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.h.sendMessage(m);

    }
}

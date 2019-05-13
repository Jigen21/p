package com.example.axelh.tpposta;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XmlParser
{

    public static List<Noticia> traerNoticias(String s) throws XmlPullParserException, IOException {
        List<Noticia> noticias = new ArrayList<Noticia>();
        XmlPullParser parser = Xml.newPullParser();

        int event=parser.getEventType();
        parser.setInput(new StringReader(s));
        Noticia n = new Noticia();


        while(event!=XmlPullParser.END_DOCUMENT)
        {
                switch (event)
                {

                    case XmlPullParser.START_TAG:


                        if("title".equals(parser.getName()))
                        {
                            n = new Noticia();

                            n.setTitulo(parser.nextText());
                            Log.d("llegue",n.getTitulo());
                        }

                        if("link".equals(parser.getName()))
                        {
                            n.setLinkpagina(parser.nextText());

                        }


                        if("description".equals(parser.getName()))
                        {
                            n.setDescripcion(parser.nextText());
                            //noticias.add(n);


                        }

                       /* if("image".equals(parser.getName()))
                        {
                            n.setLinkimagen(parser.nextText());
                            Log.d("rrr",n.getLinkimagen());
                            //n.setDatosimagen(MiConnec.traerImagen(n.getLinkimagen()));
                        }*/

                       if("enclosure".equals(parser.getName()))
                       {
                           n.setLinkimagen(parser.getAttributeValue(null,"url"));
                           Log.d("rrr",n.getLinkimagen());
                           n.setDatosimagen(MiConnec.traerImagen(n.getLinkimagen()));
                           noticias.add(n);

                       }





                }

                event=parser.next();



        }

        return noticias;

    }


}

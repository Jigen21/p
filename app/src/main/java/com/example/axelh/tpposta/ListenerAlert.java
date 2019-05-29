package com.example.axelh.tpposta;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

public class ListenerAlert implements DialogInterface.OnClickListener
{


    @Override
    public void onClick(DialogInterface dialog,int which) {
                  Log.d("dialog","click")     ;
    }
}

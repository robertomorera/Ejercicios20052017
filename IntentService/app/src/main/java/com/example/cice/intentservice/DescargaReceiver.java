package com.example.cice.intentservice;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;

public class DescargaReceiver extends BroadcastReceiver {

    private Context contexto;

    public DescargaReceiver(Context context){
        this.contexto=context;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        Log.d(getClass().getCanonicalName(),"INTENT SERVICE FINALIZADO");
        //Recogemos el bitmap.
        Bitmap bitmap=(Bitmap)intent.getParcelableExtra("imagen");

        MainActivity activity=(MainActivity)contexto;
        activity.setImagen(bitmap);



    }
}

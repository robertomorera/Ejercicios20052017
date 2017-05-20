package com.example.cice.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class MyIntentService extends IntentService {

    private Bitmap getBitMap(String url){
        Bitmap bitmap=null;
        InputStream is=null;
        HttpURLConnection httpURLConnection=null;
        URL url_net=null;
        int respuesta=-1;
        try{
            url_net=new URL(url);
            httpURLConnection=(HttpURLConnection)url_net.openConnection();

            respuesta=httpURLConnection.getResponseCode();
            if(respuesta==HttpURLConnection.HTTP_OK){
                is=httpURLConnection.getInputStream();
                bitmap= BitmapFactory.decodeStream(is);
                is.close();
            }

        }catch(Exception e){
            Log.e(getClass().getCanonicalName(),"ERROR",e);

        }finally{
            if(httpURLConnection!=null){
                httpURLConnection.disconnect();
            }
        }
        return bitmap;
    }


    private Bitmap comprimirImagen(Bitmap bitmap,int alto,int ancho){

        return Bitmap.createScaledBitmap(bitmap,ancho,alto,true);
    }


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Aquí iniciamos el servicio.
        Log.d(getClass().getCanonicalName(),"INICIANDO INTENT SERVICE");
        //TODO HAGO EL  SERVICIO.
        Bitmap bitmap=getBitMap("http://www.art-center.ru/upload/Ireland_Dublin_Night.jpg");
        Bitmap bitmap_reducido=comprimirImagen(bitmap,300,300);
        //Informo que ha acabado el servicio
        Intent intentFin=new Intent("IS_FIN");
        intentFin.putExtra("imagen",bitmap_reducido);
        sendBroadcast(intentFin);
    }


}

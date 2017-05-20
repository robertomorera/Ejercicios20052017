package com.example.cice.intentservice;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Preparo el listener del fin de servicio.
        IntentFilter intentFilter=new IntentFilter("IS_FIN");
        BroadcastReceiver br=new DescargaReceiver(this);
        registerReceiver(br,intentFilter);
        //Lanzar el servicio.
        Intent intent=new Intent(this,MyIntentService.class);
        startService(intent);
    }

    public void setImagen(Bitmap bitmap){
        ImageView imageView=(ImageView)findViewById(R.id.imagen);
        imageView.setImageBitmap(bitmap);
    }

}

package com.example.cice.animationapp1;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView=(ImageView)findViewById(R.id.imagen);
        imageView.setBackgroundResource(R.drawable.rollo_imagenes);

        AnimationDrawable ad=(AnimationDrawable)imageView.getBackground();
        ad.start();



    }
}

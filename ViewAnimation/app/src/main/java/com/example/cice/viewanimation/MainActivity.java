package com.example.cice.viewanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv=(TextView)findViewById(R.id.gol);

        //ANIMATION VIEW "TRADITIONAL".
        /*Animation animation=AnimationUtils.loadAnimation(this,R.anim.animation_view);
        tv.startAnimation(animation);*/

        //ANIMATION PROPERTY OBJECTANIMATOR.
        /*ValueAnimator va= (ValueAnimator)AnimatorInflater.loadAnimator(this,R.animator.animation_property_object);
        va.setTarget(tv);
        va.start();*/


        //ANIMATION PROPERTY VALUEANIMATOR
        /*ValueAnimator va1=(ValueAnimator)AnimatorInflater.loadAnimator(this,R.animator.animation_property_animator);
        va1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float animated_value=(float)animation.getAnimatedValue();
                tv.setTranslationY(animated_value);
            }
        });

        va1.start();*/

        //ANIMATION PROPERTY SET
        AnimatorSet animatorSet=(AnimatorSet)AnimatorInflater.loadAnimator(this,R.animator.animacion_property_set);
        animatorSet.setTarget(tv);
        animatorSet.start();



    }
}

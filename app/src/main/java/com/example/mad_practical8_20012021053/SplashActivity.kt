package com.example.mad_practical8_20012021053

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class SplashActivity : AppCompatActivity() , Animation.AnimationListener{
    lateinit var logo_img:ImageView
    lateinit var logoFrameByFrameAnimation: AnimationDrawable
    lateinit var twinAmimation:Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        logo_img=findViewById(R.id.img1)
        logo_img.setBackgroundResource(R.drawable.uvpce_logo_list)
        logoFrameByFrameAnimation=logo_img.background as AnimationDrawable

        twinAmimation=AnimationUtils.loadAnimation(this, R.anim.twin_animation)
        twinAmimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if(hasFocus){
            logoFrameByFrameAnimation.start()
            logo_img.startAnimation(twinAmimation)
        }

        else{
            logoFrameByFrameAnimation.stop()
        }
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {

        Intent(this, MainActivity::class.java).apply {
            overridePendingTransition(R.anim.scale_in, R.anim.scale_out)
            startActivity(this) }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }

}
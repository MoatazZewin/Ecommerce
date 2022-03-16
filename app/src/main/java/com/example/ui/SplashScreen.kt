package com.example.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.ecommerce.R
import com.example.ui.activity.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var mercatoLogo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
         mercatoLogo = findViewById(R.id.splash_logo)
        val splashIntint = Intent(this, MainActivity::class.java)

        lunchLogoAnimation()
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(splashIntint)
        },3000)


    }

    private fun lunchLogoAnimation() {
        val loadAnimation = AnimationUtils.loadAnimation(baseContext, R.anim.mercato_logo_animation)
        Handler(Looper.getMainLooper()).postDelayed({
            mercatoLogo.visibility = View.VISIBLE
            mercatoLogo.startAnimation(loadAnimation)
        }, 50)

    }

}

package com.example.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.ecommerce.CreateAccount
import com.example.ecommerce.MainActivity
import com.example.ecommerce.R

class Login : AppCompatActivity() {
    lateinit var leftIcomn: ImageView
    lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

       leftIcomn = findViewById(R.id.left_icon_login)
       textview = findViewById(R.id.textViewCreate)
       leftIcomn.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        textview.setOnClickListener(View.OnClickListener {
            var intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        })


    }
}
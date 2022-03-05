package com.example.ecommerce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.ecommerce.databinding.ActivityCreateAccountBinding


class CreateAccount : AppCompatActivity() {

    lateinit var image: ImageView
    lateinit var firstName: EditText
    lateinit var lastName: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirmPass: EditText
    lateinit var mobile: EditText
    lateinit var create: Button
    lateinit var txtName: TextView
    lateinit var txtpass: TextView
    lateinit var txtPassConfirm: TextView
    lateinit var txtEmail: TextView
    private lateinit var mBinding:ActivityCreateAccountBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        mBinding = ActivityCreateAccountBinding.inflate(LayoutInflater.from(this))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        image = findViewById(R.id.left_icon_login)
        image.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        })

//        firstName = findViewById(R.id.editTextFirstName)
//        lastName = findViewById(R.id.editTextLastName)
//        email = findViewById(R.id.editTextEmail)
//        password = findViewById(R.id.editTextPassword)
//        confirmPass = findViewById(R.id.editTextConfiemPass)
//        mobile = findViewById(R.id.editTextMobile)
//        create = findViewById(R.id.button_create)
//
//        txtName = findViewById(R.id.textFirstName)
//        txtpass = findViewById(R.id.textPass)
//        txtPassConfirm = findViewById(R.id.textConfirmPass)
//        txtEmail = findViewById(R.id.textEmail)


    }










}


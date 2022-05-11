package com.example.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var pass:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email=findViewById(R.id.editTextTextEmailAddress)
        pass=findViewById(R.id.editTextTextPassword)

    }
    fun SignIn(view: android.view.View)

    {

        if(email.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email.text).matches())
            else{
                val alert=AlertDialog.Builder(this)
                    .setTitle(" Ошибка")
                    .setMessage("У вас есть незаполненные поля")
                    .setPositiveButton("Окей",null)
                    .create()
                    .show()
           // val intent= Intent(this,SignInActivity::class.java)
           // startActivity(intent)
            }
       // fun SignIn(view: View) {

    }

    }

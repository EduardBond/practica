package com.example.practica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.practica.Retrofit.myRetrofit
import com.example.practica.ui.login
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.editTextTextEmailAddress)
        pass = findViewById(R.id.editTextTextPassword)

    }

    fun Login(view: android.view.View) {

        if (email.text.toString().isNotEmpty() && pass.text.toString()
                .isNotEmpty())
        {
            val retrofit = myRetrofit.getRetrofit()
        val hashMap: HashMap<String, String> = HashMap<String, String>()
        hashMap["email"] = email.text.toString()
        hashMap["pass"] = pass.text.toString()
        val call: retrofit2.Call<login> = retrofit.login(hashMap)
        call.enqueue(object: retrofit2.Callback<login>{
            override fun onResponse(call: retrofit2.Call<login>, response: Response<login>){
                if (response.body()?.token != null){
                    login.userToken = response.body()?.token
                    startActivity(Intent(this@LoginActivity, BottomNavigation::class.java))
                    finish()
                }
            else AlertDialog.Builder(this@LoginActivity).setMessage("Неверные данные входа").show()
            }
            override fun onFailure(call: retrofit2.Call<login>, t: Throwable) {
                val toast = Toast.makeText(this@LoginActivity, t.message,Toast.LENGTH_SHORT).show()
            }
        }
        )
        } else {
            val alert = AlertDialog.Builder(this)
                .setTitle(" Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .setPositiveButton("Окей", null)
                .create()
                .show()
        }

    }
}








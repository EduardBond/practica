package com.example.practica.Retrofit

import android.telecom.Call

import com.example.practica.ui.login
import retrofit2.http.Body
import retrofit2.http.POST

interface retApi {
    @POST("/auth/login")
    fun login(@Body hashMap:HashMap <String,String>): retrofit2.Call<login>
}
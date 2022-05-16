package com.example.practica.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object myRetrofit {
    fun getRetrofit():retApi= Retrofit.Builder()
        .baseUrl("https://food.madskill.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(retApi::class.java)
     
}
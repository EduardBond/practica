package com.example.practica.ui

data class login(val token :Int)
{
    companion object login{
        var userToken:Int?=null
    }
}
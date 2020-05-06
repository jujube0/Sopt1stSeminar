package com.example.sopt1stseminar.development1

import android.app.Application

class App: Application() {

    companion object{
        lateinit var prefs : MySharedPreference
    }
    override fun onCreate(){
        prefs= MySharedPreference(applicationContext)
        super.onCreate()
    }
}
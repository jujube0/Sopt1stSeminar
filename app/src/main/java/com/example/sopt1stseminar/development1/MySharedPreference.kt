package com.example.sopt1stseminar.development1

import android.content.Context
import android.content.SharedPreferences

class MySharedPreference(context: Context) {

    val PREF_FILENAME="prefs"
    val PREF_KEY_ID=""
    val PREF_KEY_PW=""
    // 0 : Context.MODE_PRIVATE
    val prefs: SharedPreferences=context.getSharedPreferences(PREF_FILENAME, 0)

    var id: String?
        //kotlin 변수의 getter setter
        get()=prefs.getString(PREF_KEY_ID,"")
        set(value)=prefs.edit().putString(PREF_KEY_ID,value).apply()

    var pw: String?
        get() = prefs.getString(PREF_KEY_PW,"")
        set(value)=prefs.edit().putString(PREF_KEY_PW,value).apply()

    fun clear(){
        id = ""
        pw = ""
    }
//    var MyEditText: String
//    fun get(){prefs.getString(PREF_KEY_MY_EDITTEXT, "")}
//    fun set(value:String){ prefs.edit().putString(PREF_KEY_MY_EDITTEXT, value).apply()}
}
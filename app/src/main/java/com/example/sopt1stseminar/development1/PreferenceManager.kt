package com.example.sopt1stseminar.development1

import android.content.Context
import android.content.SharedPreferences

const val PREFERENCES_NAME = "login_preference"
const val DEFAULT_VALUE_STRING = ""
class PreferenceManager {

    fun getPreference(context:Context) : SharedPreferences{
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
    //String 값 저장
    fun setString(context:Context, key:String, value:String){
        val prefs: SharedPreferences = getPreference(context)
        val editor : SharedPreferences.Editor = prefs.edit()
        editor.putString(key,value)
        editor.commit()
    }
    //String 값 가져오기
    fun getString(context:Context, key:String): String{
        val prefs:SharedPreferences = getPreference(context)
        val value:String = prefs.getString(key, DEFAULT_VALUE_STRING)!!
        return value
    }
    //키 값 삭제
    fun removeKey(context:Context, key:String){
        val prefs:SharedPreferences=getPreference(context)
        val edit:SharedPreferences.Editor=prefs.edit()
        edit.remove(key)
        edit.commit()
    }
    //모든 저장 데이터 삭제
    fun clear(context:Context){
        val prefs:SharedPreferences=getPreference(context)
        val edit = prefs.edit()
        edit.clear()
        edit.commit()
    }
}
package com.example.sopt1stseminar.assignment2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sopt1stseminar.R
import com.example.sopt1stseminar.development1.PreferenceManager
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_register_confirm.setOnClickListener {
            //id / pw / nickname 입력창이 비어있으면 toast
            if(tv_register_id.text.isNullOrBlank()||tv_register_pw.text.isNullOrBlank()||tv_register_nickname.text.isNullOrBlank()){
                Toast.makeText(this,"please fill all blanks",Toast.LENGTH_SHORT).show()
            }else{
                // pw 와 pw 확인이 일치하지 않으면 toast
                if(tv_register_pw.text.toString()!=tv_register_pw2.text.toString()){

                    Toast.makeText(this, "please check your pw", Toast.LENGTH_SHORT).show()
                }else{
                    val id = tv_register_id.text.toString()
                    val pw = tv_register_pw.text.toString()
                    setData(id,pw)
                    finish()
                }

            }
        }
    }
    //id와 pw를 가져와 저장하고, loginActivity에 전달
    fun setData(id:String,pw:String){
        val intent : Intent = getIntent()
        intent.putExtra("id",id)
        intent.putExtra("pw", pw)
        PreferenceManager().setString(this,"id",id)
        PreferenceManager().setString(this,"pw",pw)
        setResult(Activity.RESULT_OK, intent)

    }
}

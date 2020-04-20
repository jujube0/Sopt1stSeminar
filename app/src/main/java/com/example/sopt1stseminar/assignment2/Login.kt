package com.example.sopt1stseminar.assignment2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sopt1stseminar.R
import com.example.sopt1stseminar.assignment1.MainActivity
import com.example.sopt1stseminar.development1.PreferenceManager
import kotlinx.android.synthetic.main.activity_login.*

const val GET_ID_PW = 1
class Login : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener{
            //id창 또는 pw 창이 null or blank이면 toast 띄우기
            if(et_id.text.isNullOrBlank()||et_pwd.text.isNullOrBlank()){
                Toast.makeText(this, "please fill the all blanks", Toast.LENGTH_SHORT).show()
                // 아니면 main activity 로 화면 전환
            }else{
                val id = et_id.text.toString()
                val pw = et_pwd.text.toString()
                saveIdPw(id,pw)
                sendToMain()
            }

        }
        //회원가입하기 버튼이 누르면 회원가입창 열기
        tv_register.setOnClickListener {
            startActivityForResult(Intent(this, Register::class.java), GET_ID_PW)
        }
    }
    //SharedPreference에 저장
    fun saveIdPw(id:String,pw:String){
        PreferenceManager().setString(this, "id", id)
        PreferenceManager().setString(this, "pw", pw)
    }
    //SharedPreference로부터 로그인 기록을 가져오면 true, 로그인 기록이 없으면 false
    fun getIdPw():Boolean{
        val id = PreferenceManager().getString(this, "id")
        val pw = PreferenceManager().getString(this, "pw")
        return !id.equals("")&&!pw.equals("")
    }
    // main화면으로 보내기
    fun sendToMain(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
    //자동로그인
    override fun onStart() {
        super.onStart()
       if(getIdPw()){
           sendToMain()
           Toast.makeText(this, "자동로그인되었습니다", Toast.LENGTH_SHORT).show()
       }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== GET_ID_PW){
            if(resultCode == Activity.RESULT_OK){
                val id = data!!.getStringExtra("id")
                val pw = data!!.getStringExtra("pw")
                et_id.setText(id)
                et_pwd.setText(pw)
            }

        }
    }
}

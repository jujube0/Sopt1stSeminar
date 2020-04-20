package com.example.sopt1stseminar.assignment1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sopt1stseminar.R
import com.example.sopt1stseminar.assignment2.Login
import com.example.sopt1stseminar.development1.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            PreferenceManager().clear(this)
            startActivity(Intent(this,Login::class.java))
            finish()
        }

    }
}

package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LaunchScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)

        object: CountDownTimer(1500, 1500){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@LaunchScreen, PatientRegScreen::class.java)
                startActivity(intent)
                this@LaunchScreen.finish()
            }
        }.start()
    }
}
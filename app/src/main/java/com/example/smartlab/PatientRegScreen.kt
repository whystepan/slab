package com.example.smartlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PatientRegScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_reg_screen)

        val tvSkipReg: TextView = findViewById(R.id.tvSkipReg)

        tvSkipReg.setOnClickListener {
            val intent = Intent(this@PatientRegScreen, MainScreen::class.java)
            startActivity(intent)
            this@PatientRegScreen.finish()
        }
    }
}
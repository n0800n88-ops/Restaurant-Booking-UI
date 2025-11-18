package com.hfad.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val reservationButton: Button = findViewById(R.id.reservationButton)
        reservationButton.setOnClickListener {
            startActivity(Intent(this, ReservationActivity::class.java))
        }
    }
}

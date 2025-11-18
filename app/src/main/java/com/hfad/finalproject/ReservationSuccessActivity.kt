package com.hfad.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ReservationSuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_success)

        val name = intent.getStringExtra("RESERVATION_NAME")
        val phone = intent.getStringExtra("RESERVATION_PHONE")
        val time = intent.getStringExtra("RESERVATION_TIME")
        val number = intent.getStringExtra("RESERVATION_NUMBER")

        val successMessage: TextView = findViewById(R.id.successMessage)
        successMessage.text = "訂位成功!\n\n訂位者姓名: $name\n訂位者電話: $phone\n訂位時間: $time\n訂位人數: $number"


        val renewbutton: Button = findViewById(R.id.reneworder)

        // 設置按鈕點擊監聽器
        renewbutton.setOnClickListener {
            // 創建一個 Intent 來啟動 login Activity
            val intent = Intent(this, ReservationActivity::class.java)
            startActivity(intent)
        }


        val logoutButton: Button = findViewById(R.id.logoutbutton)

        // 設置按鈕點擊監聽器
        logoutButton.setOnClickListener {
            // 創建一個 Intent 來啟動 login Activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
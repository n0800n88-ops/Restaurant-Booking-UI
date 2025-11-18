package com.hfad.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 找到開始按鈕
        val startButton: Button = findViewById(R.id.startButton)

        // 設置按鈕點擊監聽器
        startButton.setOnClickListener {
            // 創建一個 Intent 來啟動 login Activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}
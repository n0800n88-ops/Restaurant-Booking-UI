package com.hfad.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class summary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val pizzaName = intent.getStringExtra("PIZZA_NAME")
        val extraItems = intent.getStringArrayExtra("EXTRA_ITEMS") ?: arrayOf()
        val totalPrice = intent.getIntExtra("TOTAL_PRICE", 0)

        val orderSummaryTextView: TextView = findViewById(R.id.order_summary)
        val totalPriceTextView: TextView = findViewById(R.id.total_price)

        val orderSummary = StringBuilder("訂購的商品:\n$pizzaName\n\n")
        if (extraItems.isNotEmpty()) {
            orderSummary.append("加購商品:\n")
            for (item in extraItems) {
                orderSummary.append("$item\n")
            }
        }

        orderSummaryTextView.text = orderSummary.toString()
        totalPriceTextView.text = "總價: $totalPrice 元"

        val renewbutton: Button = findViewById(R.id.reneworder)

        // 設置按鈕點擊監聽器
        renewbutton.setOnClickListener {
            // 創建一個 Intent 來啟動 login Activity
            val intent = Intent(this, OrderActivity::class.java)
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

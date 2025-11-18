package com.hfad.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val timeChipGroup: ChipGroup = findViewById(R.id.time_chip_group)
        val numberPicker: Spinner = findViewById(R.id.numberPicker)
        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val phoneEditText: EditText = findViewById(R.id.phoneEditText)
        val reserveButton: Button = findViewById(R.id.reserveButton)

        // 设置Spinner的数据源
        val numberAdapter = ArrayAdapter.createFromResource(
            this,
            R.array.number_array,
            android.R.layout.simple_spinner_item
        )
        numberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        numberPicker.adapter = numberAdapter

        reserveButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val phone = phoneEditText.text.toString()

            if (name.isBlank() || phone.isBlank()) {
                Toast.makeText(this, "請輸入訂位者姓名和電話", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedChipId = timeChipGroup.checkedChipId
            if (selectedChipId == -1) {
                Toast.makeText(this, "請選擇訂位時間", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedChip: Chip = findViewById(selectedChipId)
            val time = selectedChip.text.toString()

            val number = numberPicker.selectedItem.toString()
            if (number.isBlank()) {
                Toast.makeText(this, "請選擇訂位人數", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ReservationSuccessActivity::class.java).apply {
                putExtra("RESERVATION_TIME", time)
                putExtra("RESERVATION_NUMBER", number)
                putExtra("RESERVATION_NAME", name)
                putExtra("RESERVATION_PHONE", phone)
            }
            startActivity(intent)
        }
    }
}

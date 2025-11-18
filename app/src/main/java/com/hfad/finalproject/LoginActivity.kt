package com.hfad.finalproject

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText: EditText = findViewById(R.id.email)
        val passwordEditText: EditText = findViewById(R.id.password)
        val loginButton: Button = findViewById(R.id.button)
        val errorMessage: TextView = findViewById(R.id.errorMessage)
        val showPasswordCheckBox: CheckBox = findViewById(R.id.showPasswordCheckBox)
        val roleGroup: RadioGroup = findViewById(R.id.roleGroup)

        // 顯示/隱藏密碼
        showPasswordCheckBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                passwordEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                passwordEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            passwordEditText.setSelection(passwordEditText.text.length) // 光标移动到文本末尾
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val selectedRoleId = roleGroup.checkedRadioButtonId
            val selectedRole = findViewById<RadioButton>(selectedRoleId)?.text.toString()

            if (selectedRole == "外帶" && email == "Togo" && password == "54321") {
                val intent = Intent(this, OrderActivity::class.java)
                startActivity(intent)
            } else if (selectedRole == "內用訂位" && email == "Forhear" && password == "12345") {
                val intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
            } else {
                errorMessage.visibility = TextView.VISIBLE
            }
        }
    }
}

package com.hfad.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val pizzaGroup: RadioGroup = findViewById(R.id.pizza_group)
        val parmesanChip: Chip = findViewById(R.id.parmesan)
        val chiliOilChip: Chip = findViewById(R.id.chili_oil)
        val eggChip: Chip = findViewById(R.id.egg)
        val soupChip: Chip = findViewById(R.id.soup)
        val fryChip: Chip = findViewById(R.id.fry)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener {
            val selectedPizzaId = pizzaGroup.checkedRadioButtonId
            if (selectedPizzaId == -1) {
                Toast.makeText(this, "請選擇訂購的pizza", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedPizza: RadioButton = findViewById(selectedPizzaId)
            val pizzaName = selectedPizza.text.toString()
            val pizzaPrice = 200

            var totalPrice = pizzaPrice
            val extraItems = mutableListOf<String>()

            if (parmesanChip.isChecked) {
                totalPrice += 149
                extraItems.add(parmesanChip.text.toString())
            }
            if (chiliOilChip.isChecked) {
                totalPrice += 30
                extraItems.add(chiliOilChip.text.toString())
            }
            if(eggChip.isChecked){
                totalPrice += 99
                extraItems.add(eggChip.text.toString())
            }
            if(soupChip.isChecked){
                totalPrice += 40
                extraItems.add(soupChip.text.toString())
            }
            if(fryChip.isChecked){
                totalPrice += 149
                extraItems.add(fryChip.text.toString())
            }

            val intent = Intent(this, summary::class.java).apply {
                putExtra("PIZZA_NAME", pizzaName)
                putExtra("EXTRA_ITEMS", extraItems.toTypedArray())
                putExtra("TOTAL_PRICE", totalPrice)
            }
            startActivity(intent)
        }
    }
}

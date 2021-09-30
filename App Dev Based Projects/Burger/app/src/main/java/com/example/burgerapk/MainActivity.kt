package com.example.burgerapk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val rgmeat = findViewById<RadioGroup>(R.id.rgMeat)
            val typeOfMeat = rgmeat.checkedRadioButtonId
            var meat = findViewById<RadioButton>(typeOfMeat)
            val cheese = findViewById<CheckBox>(R.id.cbCheese).isChecked
            val onion = findViewById<CheckBox>(R.id.cbOnion).isChecked
            val salad = findViewById<CheckBox>(R.id.cbSalad).isChecked
            val orderString = "You have ordered a burger with:\n"+
                    "${meat.text},\n"+(if(cheese) "Cheese,\n" else "") + (if(onion) "Onion,\n" else "") + (if(salad) "Salad" else "")
            val tvOrder = findViewById<TextView>(R.id.tvOrder)
            tvOrder.text = orderString
        }
    }
}
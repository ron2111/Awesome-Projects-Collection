package com.example.minesweeper

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.custom_layout_maker.*

class CustomBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_layout_maker)

        // edit text
        val height = findViewById<TextInputLayout>(R.id.hi)
        val width = findViewById<TextInputLayout>(R.id.wi)
        val mines = findViewById<TextInputLayout>(R.id.mi)


        // when user clicks submit button
        submit.setOnClickListener {

            //after clicking submit button, this will transfer or pass the value which the user has entered
            var heigh = Integer.parseInt(height.editText?.text.toString())
            var widt = Integer.parseInt(width.editText?.text.toString())
            var mine = Integer.parseInt(mines.editText?.text.toString())

            // passing the values to the gameplay activity
            val intent = Intent(this, GamePlay::class.java).apply {
                putExtra("height", heigh)  //put the value
                putExtra("width", widt)
                putExtra("mines", mine)
            }
            startActivity(intent)
        }

    }
}
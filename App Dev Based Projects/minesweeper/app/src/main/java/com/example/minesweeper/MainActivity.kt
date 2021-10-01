package com.example.minesweeper

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var level = ""
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = this.getSharedPreferences("time", Context.MODE_PRIVATE)
        best_time.text=sharedPreferences.getString("Best","00:00")
        val ltime: String? =sharedPreferences.getString("Last","00:00")

        last_game_time.text= ltime

        //when user clicks on Make Custom Button
        customBoard_button.setOnClickListener{
            val intent = Intent(this@MainActivity, CustomBoard::class.java).apply {
                putExtra("height", 9)  //put the value
                putExtra("width", 9)
                putExtra("mines", 40)
            }
            startActivity(intent)
        }

        // if user clicks on easy radio button
        easy_button.setOnClickListener {
            level="easy"
        }

       //if user clicks on medium difficulty radio button
        moderate_button.setOnClickListener{
            level="medium"
        }

       //if user clicks on hard difficulty radio button
        hard_button.setOnClickListener{
            level="hard"
        }

        //start button is clicked
        start_button.setOnClickListener {
            if(level=="")
            {
                Toast.makeText(this, "Choose Valid Option", Toast.LENGTH_SHORT).show()
            }
            else
                {
                    val intent = Intent(this, GamePlay::class.java).apply {
                    putExtra("selectedLevel", level)
                    putExtra("flag", 1)
                    }
                startActivity(intent)
               }
        }

        instruction.setOnClickListener {
            showInstructions()
        }
    }

    private fun showInstructions() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setTitle("INSTRUCTIONS")
        builder.setMessage("The purpose of the game is to open all the cells of the board which do not contain a bomb. You lose if you set off a bomb cell.\n" +
                "\n" +
                "Every non-bomb cell you open will tell you the total number of bombs in the eight neighboring cells. Once you are sure that a cell contains a bomb, you can right-click to put a flag it on it as a reminder. Once you have flagged all the bombs around an open cell, you can quickly open the remaining non-bomb cells by shift-clicking on the cell.\n" +
                "\n" +
                "To start a new game (abandoning the current one), just click on the yellow face button.\n" +
                "\n" +
                "Happy mine hunting!")

        builder.setCancelable(false)

        builder.setPositiveButton("OK"
        ){ dialog, which ->

        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    override fun onBackPressed() {
        finishAffinity()
    }

}
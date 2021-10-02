package com.example.minesweeper

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.board.*
import kotlin.random.Random

class GamePlay: AppCompatActivity() {

    private lateinit var chronometer : Chronometer

    var choice : Int = 1
    var flaggedMines = 0
    var fastestTime = " NA"
    var lastGameTime = " NA"
    var status  = Status.ONGOING
    private lateinit var chronomter: Chronometer
    private var isPlay = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.board)

        chronomter = findViewById(R.id.time_count)

        if (!isPlay){
            chronomter.base = SystemClock.elapsedRealtime()
            chronomter.start()
            Toast.makeText(this, "Game Starts", Toast.LENGTH_SHORT).show()
            isPlay  =true

        }

        val intent = intent
        var flag = intent.getIntExtra("flag", 2)

        // Setting up board according to the option selected in MainActivity
        if (flag == 1) {
            var level = intent.getStringExtra("selectedLevel")
            if (level.equals("easy")) {
                SetUpBoard(6, 6, 8)
            } else if (level.equals("medium")) {
                SetUpBoard(10, 10, 18)
            } else if (level.equals("hard")) {
                SetUpBoard(14, 14, 28)
            }
        } else {
            var row = intent.getIntExtra("height", 0)
            var col = intent.getIntExtra("width", 0)
            var mine = intent.getIntExtra("mines", 0)
            SetUpBoard(row, col, mine)
        }

        // Restarting the game
        restart_button.setOnClickListener{
            gameRestart()
        }

    }

    private fun SetUpBoard (row: Int, col: Int, mine: Int)
    {

        // Setting up total number of mines
        mine_count.text = ""+mine

        // Array of buttons to find the position of a particular button
        val cellBoard = Array(row) { Array(col) {MineCell(this)}}

        action_click.setOnClickListener{
            if(choice==1) {
                action_click.setImageResource(R.drawable.flag)
                choice=2
            }else{
                action_click.setImageResource(R.drawable.mine)
                choice=1
            }
        }

        //set the layout
        var counter = 1
        var isFirstClick = true

        val params1 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,0
        )
        val params2 = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.MATCH_PARENT,
        )

        for(i in 0 until row) {
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.HORIZONTAL
            linearLayout.layoutParams = params1
            params1.weight = 1.0F

            for (j in 0 until col) {

                // makeing of button
                val button = MineCell(this)

                //Buttons are being stored to their corresponding locations in the array
                cellBoard[i][j] = button

                button.id = counter
                button.textSize = 18.0F
                button.layoutParams = params2
                params2.weight = 1.0F
                button.setBackgroundResource(R.drawable.button)

                button.setOnClickListener{

                    // Checking for first click
                    if(isFirstClick){
                        isFirstClick = false

                        // Setting up mines
                        setMines(i,j,mine,cellBoard,row,col)

                        //Start Timer
                        startTimer()

                    }

                    move(choice, i, j, cellBoard, row, col,mine)
                    display(cellBoard)

                }

                linearLayout.addView(button)
                counter++
            }
            main_buttons.addView(linearLayout)
        }

    }

    private fun setMines(row:Int, col:Int, mine:Int, cellBoard:Array<Array<MineCell>>,rowSize:Int, colSize:Int) {
        //Generate random coordinates to set mine
        var mineCount = mine
        var i=1
        while(i<=mineCount){
            var r = (Random(System.nanoTime()).nextInt(0, rowSize))
            var c = (Random(System.nanoTime()).nextInt(0, colSize))
            if(r==row || cellBoard[r][c].isMine){
                continue
            }
            cellBoard[r][c].isMine = true
            cellBoard[r][c].value = -1
            updateNeighbours(r,c,cellBoard,rowSize,colSize)
            i++;
        }
    }

    // Update the neighbours after setting mine
    private fun updateNeighbours(row: Int,column: Int,cellBoard: Array<Array<MineCell>>,rowSize:Int,colSize:Int) {
        for (i in movement) {
            for (j in movement) {
                if(((row+i) in 0 until rowSize) && ((column+j) in 0 until colSize) && cellBoard[row+i][column+j].value != MINE)
                    cellBoard[row+i][column+j].value++
            }
        }
    }

    //    timer will start when user first clicks on the board
    private fun startTimer(){
        chronometer = findViewById(R.id.time_count)
        chronometer.base = SystemClock.elapsedRealtime()
        chronometer.start()
    }

    // Move function
    private fun move(choice: Int, x: Int, y:Int, cellBoard:Array<Array<MineCell>>, rowSize: Int,colSize: Int,mine:Int): Boolean{

        if(choice==1){
            if(cellBoard[x][y].isMarked || cellBoard[x][y].isRevealed){
                return false
            }
            if(cellBoard[x][y].value == MINE){
                status = Status.LOST;
                updateScore()
                return true
            }
            else if(cellBoard[x][y].value >0){
                cellBoard[x][y].isRevealed = true
                checkStatus(cellBoard,rowSize,colSize);
                return true
            }
            else if(cellBoard[x][y].value==0){
                handleZero(x,y,cellBoard,rowSize,colSize)
                checkStatus(cellBoard,rowSize,colSize);
                return true
            }

        }
        if(choice == 2){

            if(cellBoard[x][y].isRevealed) return false

            else if(cellBoard[x][y].isMarked){
                flaggedMines--
                cellBoard[x][y].setBackgroundResource(R.drawable.button)
                cellBoard[x][y].isMarked = false
                checkStatus(cellBoard,rowSize,colSize)
            }
            else {
                if(flaggedMines==mine){
                    Toast.makeText(this,"You cannot mark more than $mine mines", Toast.LENGTH_LONG).show()
                    return false
                }
                flaggedMines++
                cellBoard[x][y].isMarked = true;
                checkStatus(cellBoard, rowSize, colSize)
            }
            var finalMineCount = mine-flaggedMines
            mine_count.text = ""+finalMineCount
            return true;
        }

        return false
    }

    // Handles when board[x][y]==0
    private val xDir = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    private val yDir = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    private fun handleZero(x:Int ,y:Int, cellBoard:Array<Array<MineCell>>, rowSize: Int,colSize: Int){

        cellBoard[x][y].isRevealed = true
        for(i in 0..7){
            var xstep = x+xDir[i]
            var ystep = y+yDir[i]
            if((xstep<0 || xstep>=rowSize) || (ystep<0 || ystep>=colSize)){
                continue;
            }
            if(cellBoard[xstep][ystep].value>0 && !cellBoard[xstep][ystep].isMarked){
                cellBoard[xstep][ystep].isRevealed = true
            }else if( !cellBoard[xstep][ystep].isRevealed && !cellBoard[xstep][ystep].isMarked && cellBoard[xstep][ystep].value==0){
                handleZero(xstep,ystep,cellBoard,rowSize,colSize)

            }
        }

    }



    // To update status (ongoing/won)
    private fun checkStatus(cellBoard:Array<Array<MineCell>>, rowSize:Int, colSize: Int){
        var flag1=0
        var flag2=0
        for(i in 0 until rowSize){
            for(j in 0 until colSize){
                if(cellBoard[i][j].value==MINE && !cellBoard[i][j].isMarked){
                    flag1=1
                }
                if(cellBoard[i][j].value!=MINE && !cellBoard[i][j].isRevealed){
                    flag2=1
                }
            }
        }
        if(flag1==0 || flag2==0) status = Status.WON
        else status = Status.ONGOING

        if(status==Status.WON) updateScore()

    }

    //restart game using smilyincon
    private fun gameRestart() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setMessage("Do you want to restart the game ?")
        builder.setTitle("Alert!")
        builder.setCancelable(false)

        builder.setPositiveButton("Yes"
        ){ dialog, which ->
            val intent = getIntent()
            finish()
            startActivity(intent)
        }

        builder.setNegativeButton("No"
        ) { dialog, which -> }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    // On pressing back button
    override fun onBackPressed() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)

        builder.setMessage("Are you sure you want to exit the game?")
        builder.setTitle("Game is still ongoing!")
        builder.setCancelable(false)

        builder.setPositiveButton("Yes"
        ){ dialog, which ->
            updateScore()
            toMainActivity()
            finish()
            super.onBackPressed()
        }

        builder.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
            }
        })

        val alertDialog = builder.create()
        alertDialog.show()
    }

    // Saving chromometer state
    // This function is used to update and store highscore and lastgame time
    private fun updateScore(){
        chronometer.stop()

        // Getting elapsed time from chronometer
        val elapsedTime = SystemClock.elapsedRealtime() - chronometer.base;
        val sharedPref = getPreferences(Context.MODE_PRIVATE)
        val lastTime = elapsedTime.toInt()

        // Setting up highscore
        var highScore = sharedPref.getInt(getString(R.string.saved_high_score_key), Integer.MAX_VALUE)

        var isHighScore=false

        // Comparing high score if the last game's status is won
        if(status==Status.WON) {
            if (lastTime < highScore) {
                highScore = lastTime
                isHighScore = true
            }
            with(sharedPref.edit()) {
                putInt(getString(R.string.saved_high_score_key), highScore)
                putInt(getString(R.string.last_time), lastTime)
                commit()
            }
            // Setting time formats to send to another activity
            lastGameTime = ""+((lastTime / 1000) / 60)+" m "+((lastTime / 1000) % 60)+" s"
        }
        else{
            lastGameTime = " Lost!"
            fastestTime = " NA"
        }

        if(highScore==Integer.MAX_VALUE){
            fastestTime = " NA"
        }
        else {
            // Setting time formats to send to another activity
            fastestTime = "" + ((highScore / 1000) / 60) + " m " + ((highScore / 1000) % 60) + " s";
        }

//        if user WIN then sending the result to result activity
        if(status == Status.WON){


            var currentTime=time_count.text.toString()
            println("current time $currentTime" )
            val sharedPreferences: SharedPreferences =
                this.getSharedPreferences("time", Context.MODE_PRIVATE)

            val best=sharedPreferences.getString("Best","00.00")
            if(best!! > currentTime){
                sharedPreferences.edit().putString("Best",currentTime).apply()
            }
           time_count.stop()

            Toast.makeText(this, "BADHAI HOO JIT GAYE APP .... PARTY ?? ", Toast.LENGTH_SHORT).show()
        }

//        if user LOST then seding the result to main activity
        else if(status == Status.LOST){

            var currentTime=time_count.text.toString()
            println("current time $currentTime" )

            val sharedPreferences: SharedPreferences =
                this.getSharedPreferences("time", Context.MODE_PRIVATE)

            sharedPreferences.edit().putString("Last",currentTime).apply()
            time_count.stop()

            Toast.makeText(this, "YOU LOST BROOO ... READ THE INSTRUCTIONS PROVIDED IN THE i BUTTON AND TRY AGAIN", Toast.LENGTH_LONG).show()
        }

    }


    // This will carry data to store highscore and last game time
    // on getting back to main activity
    private fun toMainActivity(){
        Log.d("MainActivity", "inside to main$fastestTime $lastGameTime")
        val intent = Intent(this@GamePlay,MainActivity::class.java)
        intent.putExtra("highScore",fastestTime)
        intent.putExtra("lastTime",lastGameTime)
        startActivity(intent)
    }




    // It will display the buttons according to the game status
    private fun display(cellBoard:Array<Array<MineCell>>) {
        cellBoard.forEach { row ->
            row.forEach {
                if(it.isRevealed)
                    setNumberImage(it)
                else if (it.isMarked)
                    it.setBackgroundResource(R.drawable.flag)
                else if (status == Status.LOST && it.value == MINE) {
                    restart_button.setBackgroundResource(R.drawable.sadhubohot)
                    it.setBackgroundResource(R.drawable.mine)
                }
               // To show that mine is not present here but it is marked
                if(status == Status.LOST && it.isMarked && !it.isMine){
                    it.setBackgroundResource(R.drawable.crossedflag)
                }
                else if (status == Status.WON && it.value == MINE) {
                    it.setBackgroundResource(R.drawable.flag)
                    restart_button.setBackgroundResource(R.drawable.happy)
                }
                else
                    it.text = " "
            }

        }
    }

    // This function will display images according to status
    // Game status is checked in display function (Called from display function)
    private fun setNumberImage(button:MineCell) {
        if(button.value==0) button.setBackgroundResource(R.drawable.zero)
        if(button.value==1) button.setBackgroundResource(R.drawable.one)
        if(button.value==2) button.setBackgroundResource(R.drawable.two)
        if(button.value==3) button.setBackgroundResource(R.drawable.three)
        if(button.value==4) button.setBackgroundResource(R.drawable.four)
        if(button.value==5) button.setBackgroundResource(R.drawable.five)
        if(button.value==6) button.setBackgroundResource(R.drawable.six)
        if(button.value==7) button.setBackgroundResource(R.drawable.seven)
        if(button.value==8) button.setBackgroundResource(R.drawable.eights)

    }


    companion object{
        const val MINE = -1
        val movement = intArrayOf(-1, 0, 1)
    }

}

// Includes all the three game status
enum class Status{
    WON,
    ONGOING,
    LOST
}
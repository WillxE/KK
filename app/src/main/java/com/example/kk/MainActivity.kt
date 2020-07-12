package com.example.kk

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.time.seconds


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View){
        val buSelected = view as Button
        var cellID = 0
        when(buSelected.id){
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9

        }
        Toast.makeText(this,"Cell ID: "+cellID,Toast.LENGTH_LONG).show()
        playGame(cellID,buSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, buSelected: Button) {
        if(activePlayer == 1){
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.BLUE)
            player1.add(cellID)
            activePlayer = 2
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.GREEN)
            player2.add(cellID)
            activePlayer = 1
        }

        buSelected.isEnabled = false

        checkWinner()

    }
    private fun checkWinner() {
        var winner = -1
        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        //row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }
        //column1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 2
        }
        //column2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 2
        }
        //column3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 2
        }
        //cross1
        if((player1.contains(1) && player1.contains(5) && player1.contains(9)) || (player1.contains(3) && player1.contains(5) && player1.contains(7))){
            winner = 1
        }
        if((player2.contains(1) && player2.contains(5) && player2.contains(9)) || (player2.contains(3) && player2.contains(5) && player2.contains(7))){
            winner = 2
        }


        if(winner == 1){
            Toast.makeText(this,"Player1 is the winner",Toast.LENGTH_LONG).show()
            reOpenGame()
        }
        if(winner == 2){
            Toast.makeText(this,"Player2 is the winner",Toast.LENGTH_LONG).show()
            reOpenGame()
        }


    }
    private fun reOpenGame() {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
        finishAffinity()

    }
}
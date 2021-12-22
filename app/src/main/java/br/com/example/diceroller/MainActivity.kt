package br.com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)

        Toast.makeText(this, "Welcome to Dice Roller", Toast.LENGTH_SHORT).show()
        rollButton.setOnClickListener() {
            rollDice()
        }
    }

    //Create a dice with a roll function
    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    //Function that roll the dice
    private fun rollDice() {
        //Create an object Dice with 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Determine which drawable based on dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        diceImage.contentDescription = diceRoll.toString()

        //Toast a final message
        Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()

    }


}
package com.evirgenoguz.zaruygulamasi

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

        var rollButton: Button = findViewById(R.id.roll)

        rollButton.setOnClickListener {

            //val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_LONG)
            //toast.show()

            //val resultTextView: TextView = findViewById(R.id.textView)
            //resultTextView.text = "6"

            rollDice()


        }

    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()
        val resultTextView2: TextView = findViewById(R.id.textView2)
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()
        resultTextView2.text = diceRoll2.toString()

        var sum: Int = diceRoll+diceRoll2
        val sumTextView: TextView = findViewById(R.id.textView3)
        sumTextView.text = sum.toString()


    }
}

class Dice(val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}
package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnRoll.setOnClickListener {
            rollDice()
        }

        rollDice()

    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll= dice.roll()

        val drawaleResource = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        binding.imgDice.setImageResource(drawaleResource)

        binding.txtResult.text = diceRoll.toString()
    }
}
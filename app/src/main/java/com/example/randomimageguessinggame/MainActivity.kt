package com.example.randomimageguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randomimageguessinggame.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var fruits = mutableListOf(R.drawable.apple, R.drawable.grapes, R.drawable.orange)
    private var mode: Boolean = true
    private var userschoice: Int = 0
    private lateinit var test: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        modeOff()
        binding.switchMode.setOnCheckedChangeListener { _, isChecked ->
            ToggleGameModed(isChecked)
        }
    }

    private fun ToggleGameModed(isChecked: Boolean) {
        if (isChecked) {
            binding.switchMode.text = getString(R.string.stop_game)
            AppleClick()
            GrapeClick()
            RandomImage()

            } else {
            binding.switchMode.text = getString(R.string.start_game)
            binding.imageView2.setImageResource(R.drawable.empty)
            binding.imageView.setImageResource(R.drawable.empty)

            modeOff()
        }
    }

    private fun GrapeClick() {
        binding.btnGrape.setOnClickListener {
            userschoice = R.drawable.grapes
             binding.imageView.setImageResource(userschoice)
        }
    }

    private fun AppleClick() {
        binding.btnApple.setOnClickListener {
            userschoice = R.drawable.apple
            binding.imageView.setImageResource(userschoice)
        }
    }

    private fun RandomImage() {
        binding.btnRandom.setOnClickListener {
            val random = (fruits).shuffled().first()
            binding.imageView2.setImageResource(random)

            if(userschoice == (random)){
                Snackbar.make(it, "Congratulations, You Win!!!", Snackbar.LENGTH_LONG).show()
            }
            else{
                Snackbar.make(it, "Sorry, You Lose...", Snackbar.LENGTH_LONG).show()
            }
        }
    }
    private fun modeOff() {
        if (mode) {
            binding.btnApple.setOnClickListener {
                Snackbar.make(it, "Start the game", Snackbar.LENGTH_LONG).show()
            }
            binding.btnGrape.setOnClickListener {
                Snackbar.make(it, "Start the game", Snackbar.LENGTH_LONG).show()
            }
            binding.btnRandom.setOnClickListener {
                Snackbar.make(it, "Start the game", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}

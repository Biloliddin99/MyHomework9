package com.example.myhomework9.Homework2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhomework9.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mySwitch.isChecked = MySharedPreference.myColor

        binding.mySwitch.setOnCheckedChangeListener { _, b ->
            MySharedPreference.myColor = b
            if (b) {
                binding.cardView.setBackgroundColor(Color.BLACK)
            } else {
                binding.cardView.setBackgroundColor(Color.WHITE)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (MySharedPreference.myColor) {
            binding.cardView.setBackgroundColor(Color.BLACK)
        } else {
            binding.cardView.setBackgroundColor(Color.WHITE)
        }
    }
}
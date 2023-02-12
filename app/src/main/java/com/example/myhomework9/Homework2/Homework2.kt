package com.example.myhomework9.Homework2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhomework9.databinding.ActivityHomework2Binding

class Homework2 : AppCompatActivity() {
    private lateinit var binding: ActivityHomework2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomework2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)

        binding.btnClick.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (MySharedPreference.myColor) {
            binding.root.setBackgroundColor(Color.BLACK)
        } else {
            binding.root.setBackgroundColor(Color.WHITE)
        }
    }
}
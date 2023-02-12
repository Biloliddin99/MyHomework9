package com.example.myhomework9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhomework9.Homework2.Homework2
import com.example.myhomework9.databinding.ActivityEnterBinding

class EnterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.home1.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        binding.home2.setOnClickListener {
            val intent = Intent(this,Homework2::class.java)
            startActivity(intent)
        }
    }
}
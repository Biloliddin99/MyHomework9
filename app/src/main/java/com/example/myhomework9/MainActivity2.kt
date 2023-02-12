package com.example.myhomework9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myhomework9.databinding.ActivityMain2Binding
import com.example.myhomework9.models.User
import com.example.myhomework9.utils.MySharedPreference

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        MySharedPreference.init(this)

        binding.btnSave.setOnClickListener {
            val list = MySharedPreference.catchList
            list.add(User(binding.editName.text.toString(),binding.editNumber.text.toString()))
            MySharedPreference.catchList = list
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

    }
}
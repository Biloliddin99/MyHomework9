package com.example.myhomework9

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.myhomework9.databinding.ActivityMainBinding
import com.example.myhomework9.models.User
import com.example.myhomework9.utils.MySharedPreference

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MySharedPreference.init(this)


//        binding.btnNext.setOnClickListener {
//            val intent = Intent(this,MainActivity2::class.java)
//            startActivity(intent)
//        }

    }

    override fun onResume() {
        super.onResume()
        loadData()
    }


    private fun loadData() {

        var str = ""
        val list = MySharedPreference.catchList
        list.forEach {
            str += "${it.name}\n${it.number}\n\n"
        }
        binding.txtView.text = str
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_plus->{
                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,MainActivity2::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
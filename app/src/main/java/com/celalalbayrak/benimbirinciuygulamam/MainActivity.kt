package com.celalalbayrak.benimbirinciuygulamam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.celalalbayrak.benimbirinciuygulamam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        println("onCreate çalıştı")

    }

    override fun onStart() {
        super.onStart()
        println("onStart çalıştı...")
    }

    override fun onResume() {
        super.onResume()
        println("onResume çalıştı..")

    }

    override fun onPause() {
        super.onPause()
        println("onPause çalıştı ")
    }
    override fun onStop() {
        super.onStop()
        println("onStop çalıştı")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy çalıştı.")
    }

    fun sonrakisayfa(view: View){
val intent = Intent(this,IkinciActivity::class.java)
        val kullaniciGirdigiDeger = binding.editText.text.toString()

        intent.putExtra("isim", kullaniciGirdigiDeger) // veriyi gönderme

        startActivity(intent)
    }




}
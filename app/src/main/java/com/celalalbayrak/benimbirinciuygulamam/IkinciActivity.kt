package com.celalalbayrak.benimbirinciuygulamam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.celalalbayrak.benimbirinciuygulamam.databinding.ActivityIkinciBinding
import com.celalalbayrak.benimbirinciuygulamam.databinding.ActivityMainBinding

class IkinciActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIkinciBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIkinciBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        val mainActivitydenGelenDeger = intent
        val kullanicidangelendeger = mainActivitydenGelenDeger.getStringExtra("isim")
        binding.textView2.text =kullanicidangelendeger


 //************************************************** ŞÖYLEDE YAZILABİLİR.....****************

//        val kullanicidangelendeger = intent.getStringExtra("isim")
//        binding.textView2.text = kullanicidangelendeger

// ********************************* VEYA  ŞÖYLE DAHA KISA BİR ŞEKİLDE YAZILABİLİR *********************************************

//        binding.textView2.text =intent.getStringExtra("isim")

    }

    /**************************** sayfaya geri dönüş işlemi için fonksiyon ***********************/

    /***** yaşam döngüsüne dikkat edilmesi gerekir bu fonksiyonu kullanırken ***********

    fun anasayfayagec(view: View)
    {
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    }
    */


}
package com.evirgenoguz.superkahramanprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun superKahramanYap(view : View){
        var isim = isimText.text.toString()
        var yas = yasText.text.toString().toIntOrNull()
        var meslek = meslekText.text.toString()



        if (yas == null){
            sonucText.text = "Sayı giriniz"
        }
        else{
            val superKahraman = SuperKahraman(isim, yas, meslek)
            sonucText.text = "İsim : ${superKahraman.isim} \n Yaş : ${superKahraman.yas} \n Meslek : ${superKahraman.meslek}"
        }



    }
}
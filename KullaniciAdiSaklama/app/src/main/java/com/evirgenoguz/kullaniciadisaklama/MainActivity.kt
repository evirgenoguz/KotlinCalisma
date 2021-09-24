package com.evirgenoguz.kullaniciadisaklama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var alinanKullaniciAdi : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Shared Preferences kullanıcaz

        sharedPreferences = this.getSharedPreferences("com.evirgenoguz.kullaniciadisaklama",
            Context.MODE_PRIVATE)

        alinanKullaniciAdi = sharedPreferences.getString("kullaniciAdi","")

        if (alinanKullaniciAdi != null){
            textView2.text = "Kayddilen Kullanıcı Adı : ${alinanKullaniciAdi}"
        }
    }

    fun kaydet(view : View){
        val kullaniciAdi = editText.text.toString()

        if (kullaniciAdi == ""){
            Toast.makeText(this, "Lütfen Bir Değer Giriniz", Toast.LENGTH_LONG).show()
        }
        else{
            sharedPreferences.edit().putString("kullaniciAdi", kullaniciAdi).apply()
            textView2.text = "Kaydedilen Kullanıcı Adı : ${kullaniciAdi}"
        }
    }

    fun sil(view : View){
        alinanKullaniciAdi = sharedPreferences.getString("kullaniciAdi", "")

        if (alinanKullaniciAdi != null){
            textView2.text = "Kaydedilen Kullanıcı Adı : "
            sharedPreferences.edit().remove("kullaniciAdi").apply()
        }

    }

}
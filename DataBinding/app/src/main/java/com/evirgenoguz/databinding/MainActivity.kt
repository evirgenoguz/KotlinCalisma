package com.evirgenoguz.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.evirgenoguz.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.mainActivityObjesi = this
        binding.ortalamaSonuc = "0"

    }

    fun ortalamaHesap(ilkSayi: String, ikinciSayi:String){
        val ilkSayi = ilkSayi.toInt()
        val ikinciSayi = ikinciSayi.toInt()

        val ortalama = (ilkSayi + ikinciSayi) / 2

        //binding.textViewSonuc.text = ortalama.toString()

        binding.ortalamaSonuc = ortalama.toString()
    }

}
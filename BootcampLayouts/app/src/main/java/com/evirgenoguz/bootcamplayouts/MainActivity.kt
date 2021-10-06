package com.evirgenoguz.bootcamplayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.evirgenoguz.bootcamplayouts.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.hesaplaButton.setOnClickListener {
            bahsisHesapla()
        }

    }

    fun bahsisHesapla(){

        val hizmetBedeliTutar = binding.hizmetBedeliEditText.text.toString()



        val tutar = hizmetBedeliTutar.toDoubleOrNull()

        if (tutar == null){
            binding.bahsisTutariTextView.text = ""
            return
        }

        val secilenRadıoButton = binding.bahsisSecenekleriRadioGroup.checkedRadioButtonId

        val bahsisYuzdesi = when(secilenRadıoButton){
            R.id.yuzdeYirmiRadioButton -> 0.20
            R.id.yuzdeOnSekizRadioButton -> 0.18
            else -> 0.15
        }


        var bahsis = bahsisYuzdesi * tutar

        val yukariYuvarla = binding.bahsisYuvarlaSwitch.isChecked

        if (yukariYuvarla){
           bahsis = kotlin.math.ceil(bahsis)
        }

        val formatlananBahsis = NumberFormat.getCurrencyInstance(Locale("tr", "TR")).format(bahsis)
        binding.bahsisTutariTextView.text = getString(R.string.bahsis_tutari, formatlananBahsis)

    }
}
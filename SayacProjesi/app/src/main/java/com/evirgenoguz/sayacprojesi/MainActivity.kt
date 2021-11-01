package com.evirgenoguz.sayacprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.evirgenoguz.sayacprojesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Abstract Class

        object: CountDownTimer(15000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.sayacTextView.text = "Kalan: ${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                binding.sayacTextView.text = "Kalan : 0"
            }

        }.start()




    }
}
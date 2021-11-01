package com.evirgenoguz.handlerrunnableprojesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.evirgenoguz.handlerrunnableprojesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var runnable: Runnable = Runnable {  }
    var handler = Handler(Looper.myLooper()!!)

    var numara = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.baslatButton.setOnClickListener {
            numara = 0

            runnable = object: Runnable{
                override fun run() {
                    numara = numara + 1
                    binding.sayacTextView.text = "Sayaç : ${numara}"
                    handler.postDelayed(runnable, 1000)
                }
            }
            handler.post(runnable)
        }

        binding.durdurButton.setOnClickListener {
            handler.removeCallbacks(runnable)
            numara = 0
            binding.sayacTextView.text = "Sayac : 0"
        }


    }




}
package com.evirgenoguz.fragmentbtk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evirgenoguz.fragmentbtk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.firstFragmentButton.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            val firstFragment = BlankFragment()
            fragmentTransaction.replace(R.id.frameLayout, firstFragment).commit()

        }

        binding.secondFragmentButton.setOnClickListener {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            val secondFragment = BlankFragment2()
            fragmentTransaction.replace(R.id.frameLayout, secondFragment).commit()
        }

    }
}
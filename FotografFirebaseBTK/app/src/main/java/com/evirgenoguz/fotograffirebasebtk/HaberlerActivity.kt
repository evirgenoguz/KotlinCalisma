package com.evirgenoguz.fotograffirebasebtk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evirgenoguz.fotograffirebasebtk.databinding.ActivityHaberlerBinding

class HaberlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHaberlerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaberlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
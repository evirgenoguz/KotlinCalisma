package com.evirgenoguz.roombootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evirgenoguz.roombootcamp.databinding.ActivityMainBinding
import com.evirgenoguz.roombootcamp.room.KitapModel
import com.evirgenoguz.roombootcamp.room.KitaplikDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var kitaplikDb: KitaplikDatabase
    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        kitaplikDb = KitaplikDatabase.getirKitaplikDatabase(this)!!




    }
}
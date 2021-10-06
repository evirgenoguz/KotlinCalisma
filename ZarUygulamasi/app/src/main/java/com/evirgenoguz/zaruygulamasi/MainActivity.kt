package com.evirgenoguz.zaruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var baslaTusu: Button = findViewById(R.id.baslangic)
        var yaziGoster: TextView = findViewById(R.id.textView)
        var zarGoster: ImageView = findViewById(R.id.imageView)

        baslaTusu.setOnClickListener {

            var rastgele = (1..6).random()

            //Toast.makeText(this, "Tuşa Basıldı", Toast.LENGTH_SHORT).show()
            yaziGoster.text = rastgele.toString()

            when(rastgele){
                1 -> zarGoster.setImageResource(R.)

            }

        }

    }
}
package com.evirgenoguz.superkahramankitabi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.evirgenoguz.superkahramankitabi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Veri Hazırlığı

        var kahramanIsimleri = ArrayList<String>()
        kahramanIsimleri.add("Batman")
        kahramanIsimleri.add("Spiderman")
        kahramanIsimleri.add("Superman")


        //Verimsiz Tanımlamalar

        val batmanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.batman)
        val spidermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.spiderman)
        val supermanBitmap = BitmapFactory.decodeResource(applicationContext.resources, R.drawable.superman)

        var kahramanGorselleri = ArrayList<Bitmap>()
        kahramanGorselleri.add(batmanBitmap)
        kahramanGorselleri.add(spidermanBitmap)
        kahramanGorselleri.add(supermanBitmap)

        //ADapter

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager


        val adapter = RecyclerAdapter(kahramanIsimleri, kahramanGorselleri)
        binding.recyclerView.adapter = adapter

    }
}
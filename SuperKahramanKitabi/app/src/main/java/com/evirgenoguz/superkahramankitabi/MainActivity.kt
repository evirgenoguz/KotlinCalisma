package com.evirgenoguz.superkahramankitabi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val adapter = RecyclerAdapter(kahramanIsimleri, kahramanGorselleri)

    }
}
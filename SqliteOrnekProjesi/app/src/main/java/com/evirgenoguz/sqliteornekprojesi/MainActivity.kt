package com.evirgenoguz.sqliteornekprojesi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evirgenoguz.sqliteornekprojesi.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            //veri tabanı oluşturma
            val veritabani = this.openOrCreateDatabase("Urunler", Context.MODE_PRIVATE, null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS urunler (id INTEGER PRIMARY KEY, isim VARCHAR, fiyat INT)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Ayakkabi', 100)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Ayakkabi', 100)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Elbise', 150)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Tshirt', 50)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Atki', 200)")
            //veritabani.execSQL("INSERT INTO urunler (isim, fiyat) VALUES ('Bere', 10)")





            val cursor = veritabani.rawQuery("Select * From urunler", null)

            //val cursor = veritabani.rawQuery("Select * From urunler Where isim = 'Bere'", null)

            val idColumnIndex = cursor.getColumnIndex("id")
            val isimColumnIndex = cursor.getColumnIndex("isim")
            val fiyatColumnIndex = cursor.getColumnIndex("fiyat")

            while (cursor.moveToNext()){
                println("ID: ${cursor.getInt(idColumnIndex)}" )
                println("Isim: ${cursor.getString(isimColumnIndex)}")
                println("Fiyat: ${cursor.getInt(fiyatColumnIndex)}")
            }

            cursor.close()



        } catch (e: Exception){
            e.printStackTrace()
        }

    }
}
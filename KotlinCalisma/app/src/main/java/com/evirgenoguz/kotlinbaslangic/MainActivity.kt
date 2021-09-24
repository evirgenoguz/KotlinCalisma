package com.evirgenoguz.kotlinbaslangic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("selamlar");
        println(5*10)

        val BenimDizim = arrayOf("selam", "ali") //bu normal dizi
        println(BenimDizim[1]); //println(BenimDizim.get(1)); birbriyle aynı şeyler

        val BenimListem = arrayListOf("Ali", "Veli")
        BenimListem.add("mehmet");

        println(2);

        val KarisikListe = arrayListOf<Any>("Ali", "Veli", 49, 50) //bu şekilde farklı turden veriler tutulabilir

        val SetDizi = setOf<Any>(7, 8, 9, 9, 10);
        println(SetDizi.size);
        SetDizi.forEach {
            println(it);
        }

        val YemekKaloriMap = hashMapOf<String, Int>();
        YemekKaloriMap.put("Elma", 100);
    }
}
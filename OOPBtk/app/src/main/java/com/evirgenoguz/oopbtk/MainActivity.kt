package com.evirgenoguz.oopbtk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("-----Sınıflar-----")
        val kullanici = Kullanici("Oguz", 23)
        val kullanici2 = Kullanici("Ali", 23)

        println("-----Encapsulation-----")
        val sanatci = Sanatci("Ahmet", 50, "Muzisyen")
        //sanatci.isim = "Ayşe"
        println(sanatci.isim)

        println("-----Inheritance-----")
        val ozelSanatci = OzelSanatci("Mehmet", 13, "Tiyatrocu")
        ozelSanatci.sarkiSoyle()

        println("-----Polymorphism-----")

        //Statik Polymorphism
        val islem = Islemler()

        println(islem.carpma())
        println(islem.carpma(3, 5))

        //Dinamik Polymorphism
        val kopek = Kopek()
        println(kopek.sesCikar())

        println("-----Abstraction & Interface-----")
        kullanici.insanFonksiyonu()
        var gitar = Gitar()
        gitar.marka = "Gitar Markasi"
        gitar.elektro = true
        gitar.bilgFonk()
        println(gitar.oda)


        println("-----Lambda Gösterimi (Expressions)-----")
        val yazdigimiYazdirLambda = { verilenString: String -> println(verilenString) }

        yazdigimiYazdirLambda("Test Lambda")

        val carpmaIslemiLambda = {a: Int, b: Int -> a * b}
        println(carpmaIslemiLambda(3, 5))
    }

    fun yazdigimiYazdir(string: String){
        println(string)
    }

}
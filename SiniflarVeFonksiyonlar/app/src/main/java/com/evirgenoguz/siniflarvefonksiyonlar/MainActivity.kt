package com.evirgenoguz.siniflarvefonksiyonlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var i = 2

        if (i == 0){
            ilkFonksiyon()
        }
        else{
            ikinciFonksiyon()
        }

        cikarma(3,2)

        button.setOnClickListener{
            if (textView.text == "degistirildi"){
                textView.text = "bidaha değişti"
            }else{
                textView.text = "değiştirildi"
            }
        }

        sinifCalismasi()

        nullGuvenligi()

    }

    private fun ikinciFonksiyon() {

        println("0 değil kardeşim")
    }

    fun ilkFonksiyon(){
        println("Fonksiyon çalıştırıldı")
    }

    fun cikarma(x:Int, y:Int){
        textView.text = "Sonuc : ${x-y}"
    }

    /*
     fun degistir(view : View){
        if (textView.text == "degistirildi"){
                textView.text = "bidaha değişti"
            }else{
                textView.text = "değiştirildi"
            }
            //ikinci değiştirme olayını yapamadım ikinci ve sonraki tıkladıklarımızdaki event muhabbetini

    }
     */

    fun sinifCalismasi(){
        var superman = SuperKahraman("SuperMan",50, "Gazateci")
        textView.text = superman.isim
    }

    fun nullGuvenligi(){
        //Null, Nullability, Null Safety
        println("Null Güvenliği")

        //Tanımlama, definening
        var benimString : String?
        //koyduğum soru işareti bu değişkenin null olabileceği anlamına gelir

        //benimString değişkenim bu arada null

        //initialization
        benimString = "Oguz"

        var benimYasim : Int? = null
        println(benimYasim)

        //benimYasim = 3
        //1. yöntem null kontrolu için
        if(benimYasim != null){
            println(benimYasim * 2)
        }
        else {
            println("null hacım")
        }

        //2. yöntem
        // !! -> null olmayacak demek, ? -> null olabilir demek
        benimYasim = 3
        println(benimYasim!!.minus(2))

        //3. Yöntem elvis operatoru

        //eğer null sa sonuca 10 değğerini atar ama null değilse işlemi yapar
        val sonuc = benimYasim?.minus(2) ?: 10
        println(sonuc)

        //4. Yöntem let

        benimYasim?.let {
            println("it : " + it * 5)
        }

    }


}
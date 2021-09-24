package com.evirgenoguz.contextprojesi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Toast, Alert
        //this, this@MainActivity -> aktivitenin contexti

        //applicationContext -> app context


        Toast.makeText(this, "Hoşgeldin", Toast.LENGTH_LONG).show()

    }

    fun mesajGoster(view: View){

        val uyariMesaji = AlertDialog.Builder(this@MainActivity)
        uyariMesaji.setTitle("Şifre Hatası")

        //Lambda
        uyariMesaji.setMessage("Şifreyi yanlış girdiniz, Tekrar denemek ister misiniz?")
        uyariMesaji.setPositiveButton("Evet",DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "Tekrar Deniyorsunuz", Toast.LENGTH_LONG).show()
        })

        uyariMesaji.setNegativeButton("Hayır") {dialogInterface, i ->
            Toast.makeText(this, "Hayırı Seçtiniz, Deneyemiyorsunuz",Toast.LENGTH_LONG).show()
        }

        uyariMesaji.show()

    }
}
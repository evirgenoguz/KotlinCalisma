package com.evirgenoguz.farkliaktiviteler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_ikinci.*

class IkinciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ikinci)

        val intent = intent
        val alinanVeri = intent.getStringExtra("yollananVeri")

        textView.text = alinanVeri


    }

    fun geriDon(view : View){
        val intent = Intent(applicationContext,MainActivity::class.java)
        startActivity(intent)
    }


}
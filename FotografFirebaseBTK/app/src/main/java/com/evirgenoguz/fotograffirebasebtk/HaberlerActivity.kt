package com.evirgenoguz.fotograffirebasebtk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.evirgenoguz.fotograffirebasebtk.databinding.ActivityHaberlerBinding
import com.google.firebase.auth.FirebaseAuth

class HaberlerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHaberlerBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHaberlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.secenekler_menusu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //hangi item seçildiyse ne ypaıldıgını bu methodun içinde yazıyoruz

        if (item.itemId == R.id.fotograf_paylas){
            //fotograf paylaşma aktivitesine gidilecek
            val intent = Intent(this, FotografPaylasmaActivity::class.java)
            startActivity(intent)
        }
        else if(item.itemId == R.id.cikis_yap){
            //firebaseden de çıkış yapmamız gerekiyor.
            auth.signOut() //çıkış her türlü yapılır. Listener a gerek yok

            val intent = Intent(this, KullaniciAcitivity::class.java)
            startActivity(intent)
            finish()
        }

        return super.onOptionsItemSelected(item)
    }


}
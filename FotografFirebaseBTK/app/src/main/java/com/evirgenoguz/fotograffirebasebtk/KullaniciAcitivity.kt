package com.evirgenoguz.fotograffirebasebtk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.evirgenoguz.fotograffirebasebtk.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class KullaniciAcitivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()


        val guncelKullanici = auth.currentUser
        if (guncelKullanici != null){
            val intent = Intent(this@KullaniciAcitivity, HaberlerActivity::class.java)
            startActivity(intent)
            finish()
        }


        binding.apply {

            buttonGirisYap.setOnClickListener {
                auth.signInWithEmailAndPassword(
                    editTextEmailAddress.text.toString(),
                    editTextPassword.text.toString()
                ).addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        val guncelKullanici = auth.currentUser?.email.toString()
                        val intent = Intent(this@KullaniciAcitivity, HaberlerActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(
                        this@KullaniciAcitivity,
                        exception.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }


            buttonKayTOl.setOnClickListener {

                val email = editTextEmailAddress.text.toString()
                val sifre = editTextPassword.text.toString()

                auth.createUserWithEmailAndPassword(email, sifre).addOnCompleteListener { task ->
                    //asenkron çalışıyor burası
                    if (task.isSuccessful) {
                        //diğer aktiviteye git
                        val intent = Intent(this@KullaniciAcitivity, HaberlerActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(
                        applicationContext,
                        exception.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

}

package com.evirgenoguz.fotograffirebasebtk

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.evirgenoguz.fotograffirebasebtk.databinding.ActivityFotografPaylasmaBinding
import com.google.firebase.Timestamp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.lang.Exception
import java.util.*
import kotlin.collections.HashMap

class FotografPaylasmaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFotografPaylasmaBinding
    var secilenGorsel: Uri? = null
    var secilenBitmap: Bitmap? = null
    private lateinit var storage : FirebaseStorage
    private lateinit var auth : FirebaseAuth
    private lateinit var database : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotografPaylasmaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()
        database = FirebaseFirestore.getInstance()


        binding.buttonPaylas.setOnClickListener {
            //öncelikle depo işlemleri
            //dokumantasyon üzerinden okuyarak yapabilirsin aslında
            //firebase dokumantasyonu baya güzel anlatıyor.
            //UUID -> Universal unique id

            val uuid = UUID.randomUUID()
            val gorselIsmi = "${uuid}.jpg"

            val reference = storage.reference
            val gorselReference = reference.child("images").child(gorselIsmi)

            if (secilenGorsel != null){
                gorselReference.putFile(secilenGorsel!!).addOnSuccessListener{ taskSnapshot ->
                    println("yüklendi")
                    val yuklenenGorselReference = FirebaseStorage.getInstance().reference.child("images").child(gorselIsmi)
                    yuklenenGorselReference.downloadUrl.addOnSuccessListener { uri ->
                        val downloadUrl = uri.toString()
                        val kullaniciEmail = auth.currentUser!!.email.toString()
                        val kullaniciYorum = binding.editTextYorum.text.toString()
                        val tarih = Timestamp.now()
                        //veritabanı işlemleri burada olacak

                        val postHashMap = HashMap<String, Any>()
                        postHashMap.put("gorselurl", downloadUrl)
                        postHashMap.put("kullaniciemail", kullaniciEmail)
                        postHashMap.put("kullaniciyorum", kullaniciYorum)
                        postHashMap.put("tarih", tarih)

                        database.collection("Post").add(postHashMap).addOnCompleteListener { task ->
                            if (task.isSuccessful){
                                finish()
                            }
                        }.addOnFailureListener { exception ->
                            Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
                        }

                    }
                }.addOnFailureListener { exception ->
                    Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }


        }

        binding.imageViewGorselEkle.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                //izin alınmamış
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    1
                )
            } else {
                //izin var ise
                val galeriIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                //bunun yerine ne kullanacağımı bulamadım
                startActivityForResult(galeriIntent, 1)
            }
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        if (requestCode == 1) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //izin verilince yapılacaklar
                val galeriIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                //bunun yerine ne kullanacağımı bulamadım
                startActivityForResult(galeriIntent, 1)
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            secilenGorsel = data.data

            if (secilenGorsel != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    val source = ImageDecoder.createSource(this.contentResolver, secilenGorsel!!)
                    secilenBitmap = ImageDecoder.decodeBitmap(source)
                    binding.imageViewGorselEkle.setImageBitmap(secilenBitmap)
                } else {
                    secilenBitmap =
                        MediaStore.Images.Media.getBitmap(this.contentResolver, secilenGorsel)
                    binding.imageViewGorselEkle.setImageBitmap(secilenBitmap)
                }
            }


        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}
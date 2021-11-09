package com.evirgenoguz.yemekkitabi

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation
import com.evirgenoguz.yemekkitabi.databinding.FragmentTarifBinding
import java.io.ByteArrayOutputStream
import java.lang.Exception


class TarifFragment : Fragment() {


    var secilenGorsel: Uri? = null
    var secilenBitmap: Bitmap? = null
    private lateinit var binding: FragmentTarifBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTarifBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            //Atil hocanın gorselSeç metodu burada olacak
            buttonKaydet.setOnClickListener{
                println("Tıklandı")
                kaydet(view)
            }
            imageViewYemekResmi.setOnClickListener {
                gorselSec(it)
            }
        }

        sqlVeriAlma()

    }

    fun kaydet(view: View){
        //SQLite'a Kaydetme
        var yemekIsmi = binding.yemekAdiText.text.toString()
        val yemekMalzemeleri = binding.yemekMalzemeText.text.toString()


        if (secilenBitmap != null){
            val kucukBitmap = kucukBitmapOlustur(secilenBitmap!!, 300)

            val outputStream = ByteArrayOutputStream()
            kucukBitmap.compress(Bitmap.CompressFormat.PNG, 50, outputStream)
            val byteDizisi = outputStream.toByteArray()

            try {
                context.let {
                    val database = it!!.openOrCreateDatabase("Yemekler", Context.MODE_PRIVATE, null)
                    database.execSQL("Create Table If Not Exists yemekler (id Integer Primary Key, yemekismi Varchar, yemekmalzemesi Varchar, gorsel Blob)")

                    val sqlString = "Insert Into yemekler (yemekismi, yemekmalzemesi, gorsel) Values (?, ?, ?)"
                    val statement = database.compileStatement(sqlString)
                    statement.bindString(1, yemekIsmi)
                    statement.bindString(2, yemekMalzemeleri)
                    statement.bindBlob(3, byteDizisi)
                    statement.execute()
                }


            } catch (e: Exception){
                e.printStackTrace()
            }

            val action = TarifFragmentDirections.actionTarifFragmentToListeFragment()
            Navigation.findNavController(view).navigate(action)

        }


    }

    fun gorselSec(view: View){
      //izin önceden verilmiş mi kontrolu yapılması gerekir bundan önce manifeste de ekledik
        activity?.let {
            if (ContextCompat.checkSelfPermission(it.applicationContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                //izin iste
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            } else{
                //direk storage e git
                val galeriIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galeriIntent,2)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1){
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 2 && resultCode == Activity.RESULT_OK && data != null){
            secilenGorsel = data.data
            try {
                context?.let {
                    if (secilenGorsel != null){
                        if (Build.VERSION.SDK_INT >= 28){
                            val source = ImageDecoder.createSource(it.contentResolver, secilenGorsel!!)
                            secilenBitmap = ImageDecoder.decodeBitmap(source)
                            binding.imageViewYemekResmi.setImageBitmap(secilenBitmap)
                        }else{
                            secilenBitmap = MediaStore.Images.Media.getBitmap(it.contentResolver, secilenGorsel)
                            binding.imageViewYemekResmi.setImageBitmap(secilenBitmap)
                        }
                    }
                }


            } catch (e: Exception){

            }

        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    //Bu fonksiyonu butun uygulamalarda kullanabiliriz bitmap boyutu küçültmek için
    fun kucukBitmapOlustur(kullanicininSectigiBitmap: Bitmap, maximumBoyut: Int) : Bitmap{

        var width = kullanicininSectigiBitmap.width
        var height = kullanicininSectigiBitmap.height

        val bitmapOrani: Double = width.toDouble() / height.toDouble()

        if (bitmapOrani > 1){
            //görsel yatay
            width = maximumBoyut
            val kisaltilmişHeight = width / bitmapOrani
            height = kisaltilmişHeight.toInt()



        } else {
            //gorsel dikey
            height = maximumBoyut
            val kisaltilmişWidth = height * bitmapOrani
            width = kisaltilmişWidth.toInt()
        }

        return Bitmap.createScaledBitmap(kullanicininSectigiBitmap, width, height,true)
    }


    fun sqlVeriAlma(){
        try {

            activity?.let {
                val database = it.openOrCreateDatabase("Yemekler", Context.MODE_PRIVATE, null)
                val cursor = database.rawQuery("Select * From yemekler", null)

                val yemekIsmiIndex = cursor.getColumnIndex("yemekismi")
                val yemekIdIndex = cursor.getColumnIndex("id")

                while (cursor.moveToNext()){

                    println("Yemek: ${cursor.getString(yemekIsmiIndex)}")
                    println("id: ${cursor.getInt(yemekIdIndex)}")

                    cursor.close()
                }

            }


        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
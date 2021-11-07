package com.evirgenoguz.yemekkitabi

import android.Manifest
import android.app.Activity
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
import com.evirgenoguz.yemekkitabi.databinding.FragmentTarifBinding
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
            }
            imageViewYemekResmi.setOnClickListener {
                gorselSec(it)
            }
        }

    }

    fun kaydet(view: View){
        //SQLite'a Kaydetme
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



}
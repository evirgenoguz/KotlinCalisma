package com.evirgenoguz.roombootcamp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.evirgenoguz.roombootcamp.databinding.FragmentAnasayfaBinding
import com.evirgenoguz.roombootcamp.room.KitapModel
import com.evirgenoguz.roombootcamp.room.KitaplikDatabase
import com.google.android.material.snackbar.Snackbar

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var kitaplikDb: KitaplikDatabase

    private lateinit var kitapList: List<KitapModel?>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        kitaplikDb = KitaplikDatabase.getirKitaplikDatabase(requireContext())!!

        kitapList = kitaplikDb.kitaplikDao().tumKitaplar()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tumKitaplariGoster()

        binding.apply {
            yeniKitapButton.setOnClickListener{
                findNavController().navigate(R.id.action_anasayfaFragment_to_kitapEkleFragment)
            }

            guncelleButton.setOnClickListener {
                kitapList = kitaplikDb.kitaplikDao().tumKitaplar()
                tumKitaplariGoster()
            }

        }
    }


    fun tumKitaplariGoster(){
        binding.apply {
            if (kitapList.isEmpty()){
                Snackbar.make(requireView(), "Kitap Bulunamadı", 1000).show()
            } else{
                val kitaplikAdapter = KitaplikAdapter(kitapList)
                rvKitap.adapter = kitaplikAdapter
                rvKitap.layoutManager = GridLayoutManager(context, 2)
                rvKitap.setHasFixedSize(true)
            }
        }
    }


}
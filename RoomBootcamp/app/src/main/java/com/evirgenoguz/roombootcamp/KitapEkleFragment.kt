package com.evirgenoguz.roombootcamp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.evirgenoguz.roombootcamp.databinding.FragmentAnasayfaBinding
import com.evirgenoguz.roombootcamp.databinding.FragmentKitapEkleBinding
import com.evirgenoguz.roombootcamp.room.KitapModel
import com.evirgenoguz.roombootcamp.room.KitaplikDatabase


class KitapEkleFragment : Fragment() {

    private lateinit var binding: FragmentKitapEkleBinding
    private lateinit var kitaplikDb: KitaplikDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKitapEkleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kitaplikDb = KitaplikDatabase.getirKitaplikDatabase(requireContext())!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            buttonKitapEkle.setOnClickListener{
                val kitapAdInput = editTextKitapAd.text.toString()
                val yazarAdInput = editTextKitapYazar.text.toString()

                kitaplikDb.kitaplikDao().kitapEkle(
                    KitapModel(
                        kitapAd = kitapAdInput,
                        yazarAd = yazarAdInput
                    )
                )
                findNavController().navigate(R.id.action_kitapEkleFragment_to_anasayfaFragment)
            }
        }
    }
}
package com.evirgenoguz.bootcampnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.evirgenoguz.bootcampnavigationcomponent.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {


    private var _binding: FragmentAnasayfaBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAnasayfaBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //iki fragment arası geçiş
        binding.oynaButton.setOnClickListener {
            findNavController().navigate(R.id.anaSayfaToTahmin)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}

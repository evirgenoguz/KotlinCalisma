package com.evirgenoguz.bootcampnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.evirgenoguz.bootcampnavigationcomponent.databinding.FragmentSonucBinding
import com.evirgenoguz.bootcampnavigationcomponent.databinding.FragmentTahminBinding


class TahminFragment : Fragment() {

    private var _binding: FragmentTahminBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTahminBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tahminButton.setOnClickListener {
             findNavController().navigate(R.id.tahminToSonuc)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.evirgenoguz.besinlerkitabibtk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evirgenoguz.besinlerkitabibtk.databinding.FragmentBesinDetayiBinding


class BesinDetayiFragment : Fragment() {

    private lateinit var binding: FragmentBesinDetayiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBesinDetayiBinding.inflate(inflater, container, false)
        return binding.root
    }

}
package com.evirgenoguz.fragmentbtk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evirgenoguz.fragmentbtk.databinding.FragmentBlank2Binding


class BlankFragment2 : Fragment() {

    private var _binding: FragmentBlank2Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBlank2Binding.inflate(inflater)
        return binding.root
    }

}
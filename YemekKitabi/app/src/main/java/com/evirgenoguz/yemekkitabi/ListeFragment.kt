package com.evirgenoguz.yemekkitabi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evirgenoguz.yemekkitabi.databinding.FragmentListeBinding


class ListeFragment : Fragment() {

    private lateinit var binding: FragmentListeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListeBinding.inflate(inflater, container, false)
        return binding.root
    }


}
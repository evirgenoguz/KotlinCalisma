package com.evirgenoguz.bootcampnavigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evirgenoguz.bootcampnavigationcomponent.databinding.FragmentAnasayfaBinding
import com.evirgenoguz.bootcampnavigationcomponent.databinding.FragmentProfilBinding
import com.evirgenoguz.bootcampnavigationcomponent.databinding.FragmentSonucBinding


class SonucFragment : Fragment() {

    private var _binding: FragmentSonucBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSonucBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
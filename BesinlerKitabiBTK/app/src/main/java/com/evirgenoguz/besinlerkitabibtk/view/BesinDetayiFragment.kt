package com.evirgenoguz.besinlerkitabibtk.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.evirgenoguz.besinlerkitabibtk.databinding.FragmentBesinDetayiBinding
import com.evirgenoguz.besinlerkitabibtk.viewmodel.BesinDetayiViewModel


class BesinDetayiFragment : Fragment() {

    private var besinId = 0
    private lateinit var besinDetayiViewModel: BesinDetayiViewModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        besinDetayiViewModel = ViewModelProviders.of(this).get(BesinDetayiViewModel::class.java)
        besinDetayiViewModel.roomVerisiniAl()





        arguments?.let {
            besinId = BesinDetayiFragmentArgs.fromBundle(it).besinId
            println(besinId)
        }

        observeLiveData()

    }


    fun observeLiveData(){

        besinDetayiViewModel.besinLiveData.observe(viewLifecycleOwner, Observer {
            it?.let {
                with(binding){
                    besinIsmiDetayTextView.text = it.besinIsim
                    besinKaloriDetayTextView.text = it.besinKalori
                    besinKarbonhidratDetayTextView.text = it.besinKarbonhidrat
                    besinProteinDetayTextView.text = it.besinProtein
                    besinYagDetayTextView.text = it.besinYag
                }
            }
        })

    }

}
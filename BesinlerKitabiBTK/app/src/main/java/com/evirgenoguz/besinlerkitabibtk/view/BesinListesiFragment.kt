package com.evirgenoguz.besinlerkitabibtk.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.evirgenoguz.besinlerkitabibtk.adapter.BesinRecyclerAdapter
import com.evirgenoguz.besinlerkitabibtk.databinding.FragmentBesinListesiBinding
import com.evirgenoguz.besinlerkitabibtk.viewmodel.BesinListesiViewModel


class BesinListesiFragment : Fragment() {

    private val recyclerBesinAdapter = BesinRecyclerAdapter(arrayListOf())
    private lateinit var besinListesiViewModel: BesinListesiViewModel
    private lateinit var binding: FragmentBesinListesiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBesinListesiBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //besinListesiViewModel = ViewModelProviders.of(this).get(BesinListesiViewModel::class.java)
        besinListesiViewModel = ViewModelProvider(this).get(BesinListesiViewModel::class.java) //deneme amaçlı
        besinListesiViewModel.refreshData()

        binding.besinListesiRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.besinListesiRecyclerView.adapter = recyclerBesinAdapter


        binding.swipeRefreshLayout.setOnRefreshListener {
            with(binding){
                besinYukleniyorProgressBar.visibility = View.VISIBLE
                hataTextView.visibility = View.GONE
                besinListesiRecyclerView.visibility = View.GONE
                swipeRefreshLayout.isRefreshing = false
            }
            besinListesiViewModel.refreshData()

        }

        observeLiveData()
    }


    fun observeLiveData(){
        besinListesiViewModel.besinler.observe(viewLifecycleOwner, Observer {
            it?.let {
                binding.besinListesiRecyclerView.visibility = View.VISIBLE
                recyclerBesinAdapter.besinListesiniGuncelle(it)
            }
        })

        besinListesiViewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    binding.besinListesiRecyclerView.visibility = View.GONE
                    binding.hataTextView.visibility = View.VISIBLE
                }else{
                    binding.hataTextView.visibility = View.GONE
                }

            }
        })

        besinListesiViewModel.besinYukleniyor.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    binding.besinListesiRecyclerView.visibility = View.GONE
                    binding.besinListesiRecyclerView.visibility = View.GONE
                    binding.besinYukleniyorProgressBar.visibility = View.VISIBLE
                } else{

                    binding.besinYukleniyorProgressBar.visibility = View.GONE
                }
            }
        })

    }

}
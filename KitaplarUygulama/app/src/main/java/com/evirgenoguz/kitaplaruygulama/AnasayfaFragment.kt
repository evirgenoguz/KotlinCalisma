package com.evirgenoguz.kitaplaruygulama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.evirgenoguz.kitaplaruygulama.databinding.FragmentAnasayfaBinding
import com.evirgenoguz.kitaplaruygulama.model.Kitap
import com.evirgenoguz.kitaplaruygulama.network.ApiUtils
import com.evirgenoguz.kitaplaruygulama.response.KitaplarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    var kitaplarList: ArrayList<Kitap> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(layoutInflater)

        kitaplariGetir()
        return binding.root
    }

    private fun kitaplariGetir(){
        ApiUtils.kitapDaoInterfaceGetir().KitaplariAl().enqueue(
            object : Callback<KitaplarResponse>{
                override fun onResponse(
                    call: Call<KitaplarResponse>,
                    response: Response<KitaplarResponse>
                ) {
                    val tempList = response.body()?.books

                    tempList?.let {
                        kitaplarList = it as ArrayList<Kitap>
                    }

                    val kitaplarAdapter = KitaplarAdapter(kitaplarList)
                    binding.kitapRV.adapter = kitaplarAdapter
                    binding.kitapRV.layoutManager = GridLayoutManager(context, 2)
                    binding.kitapRV.setHasFixedSize(true)

                }

                override fun onFailure(call: Call<KitaplarResponse>, t: Throwable) {

                }

            }
        )
    }


}
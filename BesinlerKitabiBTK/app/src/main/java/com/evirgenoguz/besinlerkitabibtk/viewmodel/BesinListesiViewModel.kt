package com.evirgenoguz.besinlerkitabibtk.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evirgenoguz.besinlerkitabibtk.model.Besin

class BesinListesiViewModel: ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()

    fun refreshData(){
        val muz = Besin("Muz", "10", "5", "5", "2", "www.test.com")
        val elma = Besin("Elma", "31", "5", "5", "2", "www.test.com")
        val kivi = Besin("Kivi", "69", "5", "5", "2", "www.test.com")
        //üst tarafta normalde verileri internetten çekeceğiz
        val besinListesi = arrayListOf<Besin>(muz, elma, kivi)

        besinler.value = besinListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false


    }
}
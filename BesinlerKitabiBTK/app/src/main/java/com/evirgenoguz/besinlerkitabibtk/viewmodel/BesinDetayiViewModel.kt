package com.evirgenoguz.besinlerkitabibtk.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evirgenoguz.besinlerkitabibtk.model.Besin

class BesinDetayiViewModel : ViewModel() {

    val besinLiveData = MutableLiveData<Besin>()


    fun roomVerisiniAl(){

        val muz = Besin("Muz", "10", "5", "5", "2", "www.test.com")
        besinLiveData.value = muz
    }

}
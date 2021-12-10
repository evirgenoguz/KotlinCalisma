package com.evirgenoguz.besinlerkitabibtk.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evirgenoguz.besinlerkitabibtk.model.Besin
import com.evirgenoguz.besinlerkitabibtk.servis.BesinAPIServis
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class BesinListesiViewModel : ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()

    private val besinApiServis = BesinAPIServis()
    private val disposable = CompositeDisposable()


    fun refreshData() {
        /*val muz = Besin("Muz", "10", "5", "5", "2", "www.test.com")
        val elma = Besin("Elma", "31", "5", "5", "2", "www.test.com")
        val kivi = Besin("Kivi", "69", "5", "5", "2", "www.test.com")
        //üst tarafta normalde verileri internetten çekeceğiz
        val besinListesi = arrayListOf<Besin>(muz, elma, kivi)

        besinler.value = besinListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false*/
        verileriInternettenAl()
    }

    private fun verileriInternettenAl() {
        besinYukleniyor.value = true

        disposable.add(
            besinApiServis.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<Besin>>() {
                    override fun onSuccess(t: List<Besin>) {
                        //Başarılı Olursa
                        besinler.value = t
                        besinHataMesaji.value = false
                        besinYukleniyor.value = false
                    }

                    override fun onError(e: Throwable) {
                        //Hata Alırsak
                        besinHataMesaji.value = true
                        besinYukleniyor.value = false
                        e.printStackTrace()
                    }

                })
        )
    }

}
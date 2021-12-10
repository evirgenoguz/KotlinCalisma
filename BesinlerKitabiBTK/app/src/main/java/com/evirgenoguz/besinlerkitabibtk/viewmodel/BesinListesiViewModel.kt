package com.evirgenoguz.besinlerkitabibtk.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evirgenoguz.besinlerkitabibtk.model.Besin
import com.evirgenoguz.besinlerkitabibtk.servis.BesinAPIServis
import com.evirgenoguz.besinlerkitabibtk.servis.BesinDatabase
import com.evirgenoguz.besinlerkitabibtk.util.OzelSharedPreferences
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class BesinListesiViewModel(application: Application): BaseViewModel(application) {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinYukleniyor = MutableLiveData<Boolean>()

    private val besinApiServis = BesinAPIServis()
    private val disposable = CompositeDisposable()
    private val ozelSharedPreferences = OzelSharedPreferences(getApplication())
    private var guncellemeZamani = 10 * 60 * 1000 * 1000 * 1000L

    fun refreshData() {
        val kaydedilmeZamani = ozelSharedPreferences.zamaniAl()
        if (kaydedilmeZamani != null && kaydedilmeZamani  != 0L && System.nanoTime() - kaydedilmeZamani < guncellemeZamani){
            //sqlite çek
            verileriSQLitetanAl()
        }
        else {
            verileriInternettenAl()
        }

    }

    private fun verileriSQLitetanAl(){
        launch {
            val besinListesi = BesinDatabase(getApplication()).besinDao().getAllBesin()
            besinleriGoster(besinListesi)
            Toast.makeText(getApplication(), "Besinleri Roomdan Aldık", Toast.LENGTH_LONG).show()
        }
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
                        sqliteSakla(t)
                        Toast.makeText(getApplication(), "Besinleri İnternetten Aldık", Toast.LENGTH_LONG).show()
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

    private fun besinleriGoster(besinlerListesi: List<Besin>){
        besinler.value = besinlerListesi
        besinHataMesaji.value = false
        besinYukleniyor.value = false
    }

    private fun sqliteSakla(besinlerListesi: List<Besin>){
        launch {
            val dao = BesinDatabase(getApplication()).besinDao()
            dao.deleteAllBesin()
            val uuidListesi = dao.insertAll(*besinlerListesi.toTypedArray())
            var i = 0
            while (i < besinlerListesi.size){
                besinlerListesi[i].uuid = uuidListesi[i].toInt()
                i = i + 1
            }
            besinleriGoster(besinlerListesi)
        }
        ozelSharedPreferences.zamaniKaydet(System.nanoTime())
    }




}
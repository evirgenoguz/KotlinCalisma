package com.evirgenoguz.bootcamprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.evirgenoguz.bootcamprecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), KopeklerAdapter.SecilenKopekListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var kopekTur: String
    private var secilenKopek: KopekModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val kopekList = arrayListOf(
            KopekModel(R.drawable.avustralyacoban, "Avustralya Çoban"),
            KopekModel(R.drawable.danua, "Danua"),
            KopekModel(R.drawable.golden, "Golden"),
            KopekModel(R.drawable.husky, "Husky"),
            KopekModel(R.drawable.jackrussellterrier, "Jack Russell terrier"),
            KopekModel(R.drawable.leonberger, "Leonberger")
        )

        //Adapter Bağlama
        val kopeklerAdapter = KopeklerAdapter(kopekList, this)
        binding.kopeklerRecyclerView.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.kopeklerRecyclerView.adapter = kopeklerAdapter
        binding.kopeklerRecyclerView.setHasFixedSize(true)

        //onItemClick

        kopeklerAdapter.onItemClick = ::secilenKopekOnClick

        //RecycleView e veri ekleme
        binding.ekleFAB.setOnClickListener{
            kopekList.add(KopekModel(R.drawable.pomsky, "Pomsky"))
            kopeklerAdapter.kopeklerListGuncelle(kopekList)
        }

        binding.silFAB.setOnClickListener{
            val silinecekIndex = kopekList.indexOf(secilenKopek)
            kopekList.removeAt(silinecekIndex)
            kopeklerAdapter.kopeklerListGuncelle(kopekList)
        }

    }

    //onItemClick
    fun secilenKopekOnClick(gelenSecilenKopek: KopekModel){
        Log.e("Seçilen Kopek OnClick :", gelenSecilenKopek.kopekTur )
        secilenKopek = gelenSecilenKopek
    }



    //interface
    override fun secilenKopek(kopek: KopekModel) {
        kopekTur = kopek.kopekTur
        Log.e("Seçilen Kopek Interface : ", kopek.kopekTur)
        secilenKopek = kopek
    }
}
package com.evirgenoguz.besinlerkitabibtk.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evirgenoguz.besinlerkitabibtk.R
import com.evirgenoguz.besinlerkitabibtk.databinding.BesinRecyclerRowBinding
import com.evirgenoguz.besinlerkitabibtk.model.Besin

class BesinRecyclerAdapter(val besinListesi: ArrayList<Besin>): RecyclerView.Adapter<BesinRecyclerAdapter.BesinViewHolder>() {

    class BesinViewHolder(val besinViewHolderBinding: BesinRecyclerRowBinding  ): RecyclerView.ViewHolder(besinViewHolderBinding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = BesinRecyclerRowBinding.inflate(inflater, parent, false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.besinViewHolderBinding.besinIsmiRVTextView.text = besinListesi.get(position).besinIsim.toString()
        holder.besinViewHolderBinding.besinKaloriRVTextView.text = besinListesi.get(position).besinKalori.toString()
        //Gorsel kısmı eklenecek Glide ile
    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }

    fun besinListesiniGuncelle(yeniBesinListesi: List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()
    }



}
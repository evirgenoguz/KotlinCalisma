package com.evirgenoguz.roombootcamp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evirgenoguz.roombootcamp.databinding.ItemCardBinding
import com.evirgenoguz.roombootcamp.room.KitapModel

class KitaplikAdapter(private var kitapList: List<KitapModel?>): RecyclerView.Adapter<KitaplikAdapter.ItemCardTasarim>(){

    class ItemCardTasarim(val itemCardBinding: ItemCardBinding): RecyclerView.ViewHolder(itemCardBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCardBinding = ItemCardBinding.inflate(layoutInflater, parent, false)
        return ItemCardTasarim(itemCardBinding)
    }

    override fun onBindViewHolder(holder: ItemCardTasarim, position: Int) {
        val kitap = kitapList[position]
        holder.itemCardBinding.apply {
            if (kitap != null){
                kitapAdTextView.text = kitap.kitapAd
                yazarAdTextView.text = kitap.yazarAd
            }
        }
    }

    override fun getItemCount(): Int {
        return kitapList.size
    }

}
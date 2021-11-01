package com.evirgenoguz.superkahramankitabi

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evirgenoguz.superkahramankitabi.databinding.RecyclerRowBinding

class RecyclerAdapter(val kahramanListesi: ArrayList<String>, val kahramanGorselleri: ArrayList<Bitmap>): RecyclerView.Adapter<RecyclerAdapter.SuperKahramanVH>() {

    class SuperKahramanVH(recyclerRowBinding: RecyclerRowBinding): RecyclerView.ViewHolder(recyclerRowBinding.root){}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperKahramanVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerRowBinding = RecyclerRowBinding.inflate(layoutInflater, parent, false)
        return SuperKahramanVH(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: SuperKahramanVH, position: Int) {
        val kahraman = kahramanListesi[position]

        holder.recyclerRowBinding
    }

    override fun getItemCount(): Int {
        return kahramanListesi.size
    }

}
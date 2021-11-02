package com.evirgenoguz.superkahramankitabi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evirgenoguz.superkahramankitabi.databinding.RecyclerRowBinding

class RecyclerAdapter(val kahramanListesi: ArrayList<String>, val kahramanGorselleri: ArrayList<Int>): RecyclerView.Adapter<RecyclerAdapter.SuperKahramanVH>() {

    class SuperKahramanVH(val recyclerRowBinding: RecyclerRowBinding): RecyclerView.ViewHolder(recyclerRowBinding.root){}

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuperKahramanVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val recyclerRowBinding = RecyclerRowBinding.inflate(layoutInflater, parent, false)
        return SuperKahramanVH(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: SuperKahramanVH, position: Int) {

        holder.recyclerRowBinding.recyclerTextView.text = kahramanListesi.get(position)
        holder.recyclerRowBinding.recyclerTextView.setOnClickListener{
            val intent = Intent(holder.recyclerRowBinding.recyclerTextView.context, TanitimActivity::class.java)
            intent.putExtra("superKahramanIsmi", kahramanListesi.get(position))
            intent.putExtra("superKahramanGorseli", kahramanGorselleri.get(position))
           /*
            val singleton = SingletonClass.SecilenKahraman
            singleton.gorsel = kahramanGorselleri.get(position)
            */

            holder.recyclerRowBinding.recyclerTextView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kahramanListesi.size
    }

}
package com.evirgenoguz.bootcamprecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evirgenoguz.bootcamprecyclerview.databinding.KopekCardTasarimBinding
import java.util.ArrayList

class KopeklerAdapter(private var kopeklerList: ArrayList<KopekModel>, private val secilenKopekListener: SecilenKopekListener): RecyclerView.Adapter<KopeklerAdapter.KopekCardTasarim>() {

    var onItemClick: (KopekModel) -> Unit = {}

    class KopekCardTasarim(val kopekCardTasarimBinding: KopekCardTasarimBinding): RecyclerView.ViewHolder(kopekCardTasarimBinding.root)



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KopeklerAdapter.KopekCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val kopekCardTasarimBinding = KopekCardTasarimBinding.inflate(layoutInflater, parent, false)
        return KopekCardTasarim(kopekCardTasarimBinding)
    }

    override fun onBindViewHolder(holder: KopeklerAdapter.KopekCardTasarim, position: Int) {
        val kopek = kopeklerList[position]

        holder.kopekCardTasarimBinding.kopekImageView.setImageResource(kopek.kopekGorsel)
        holder.kopekCardTasarimBinding.kopekTurTextView.text = kopek.kopekTur

        /*holder.kopekCardTasarimBinding.kopekImageView.setOnClickListener{
            secilenKopekListener.secilenKopek(kopek)
        }*/

        holder.kopekCardTasarimBinding.root.setOnLongClickListener {
            secilenKopekListener.secilenKopek(kopek)
            true
        }


        holder.kopekCardTasarimBinding.root.setOnClickListener{
            onItemClick(kopek)

        }

    }

    override fun getItemCount(): Int {
        return kopeklerList.size
    }

    fun kopeklerListGuncelle(guncelList: ArrayList<KopekModel>){
        kopeklerList = guncelList
        notifyDataSetChanged()
    }


    interface SecilenKopekListener {
        fun secilenKopek(kopek: KopekModel)
    }


}
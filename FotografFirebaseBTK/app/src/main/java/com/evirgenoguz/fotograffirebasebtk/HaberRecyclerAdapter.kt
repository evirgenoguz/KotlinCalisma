package com.evirgenoguz.fotograffirebasebtk

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evirgenoguz.fotograffirebasebtk.databinding.RecyclerRowBinding
import com.squareup.picasso.Picasso

class HaberRecyclerAdapter(val postList: ArrayList<Post>): RecyclerView.Adapter<HaberRecyclerAdapter.PostHolder>() {

    class PostHolder(val itemViewBinding: RecyclerRowBinding): RecyclerView.ViewHolder(itemViewBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = RecyclerRowBinding.inflate(inflater, parent, false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.itemViewBinding.recylerRowKullaniciEmail.text = postList[position].kullaniciEmail
        holder.itemViewBinding.recyclerRowKullaniciYorum.text = postList[position].kullaniciYorum
        Picasso.get().load(postList[position].gorselUrl).into(holder.itemViewBinding.recyclerRowImageView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}
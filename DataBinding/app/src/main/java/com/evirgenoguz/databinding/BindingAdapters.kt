package com.evirgenoguz.databinding

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("kediAd")
fun setText(textView: TextView, isim: String){
    textView.text = "Merhaba Kedi $isim"
}

@BindingAdapter("solPadding")
fun solPaddingEkle(view: View, padding: Int){
    view.setPadding(padding, view.paddingTop, view.paddingRight, view.paddingBottom)
}

@BindingAdapter("yukariPadding", "asagiPadding")
fun paddingEkle(view: View, yukariPadding: Int, asagiPadding: Int){
    view.setPadding(view.paddingLeft, yukariPadding, view.paddingRight, asagiPadding)
}
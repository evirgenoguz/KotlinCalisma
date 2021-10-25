package com.evirgenoguz.kitaplaruygulama.response

import com.evirgenoguz.kitaplaruygulama.model.Kitap
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class KitaplarResponse(
    @SerializedName("books") @Expose var books: ArrayList<Kitap>,
    @SerializedName("success") @Expose var success: Int
)

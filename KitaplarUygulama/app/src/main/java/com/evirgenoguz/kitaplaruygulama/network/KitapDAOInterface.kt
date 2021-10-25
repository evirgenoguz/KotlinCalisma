package com.evirgenoguz.kitaplaruygulama.network

import com.evirgenoguz.kitaplaruygulama.response.KitaplarResponse
import retrofit2.Call
import retrofit2.http.GET

interface KitapDAOInterface {

    @GET("all_books.php")
    fun KitaplariAl(): Call<KitaplarResponse>

}
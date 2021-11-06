package com.evirgenoguz.roombootcamp.room

import androidx.room.*

@Dao
interface KitaplikDAO {

    @Insert
    fun kitapEkle(kitap: KitapModel)

    @Update
    fun kitapGuncelle(kitap: KitapModel)

    @Delete
    fun kitapSil(kitap: KitapModel)

    @Query("Select * From kitaplık")
    fun tumKitaplar(): List<KitapModel?>


}
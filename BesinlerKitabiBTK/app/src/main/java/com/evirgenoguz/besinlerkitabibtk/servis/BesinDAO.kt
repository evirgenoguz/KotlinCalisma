package com.evirgenoguz.besinlerkitabibtk.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.evirgenoguz.besinlerkitabibtk.model.Besin

@Dao
interface BesinDAO {
    //Data Access Object

    @Insert
    suspend fun insertAll(vararg besin: Besin): List<Long>

    //Insert -> Room, insert into
    //suspend -> coroutine scope
    //vararg -> birden fazla ve istediğimiz sayıda besin
    //List<Long> -> Long, id'ler

    @Query("Select * From besin")
    suspend fun getAllBesin() : List<Besin>

    @Query("Select * From besin Where uuid = :besinId")
    suspend fun getBesin(besinId: Int): Besin

    @Query("Delete From besin")
    suspend fun deleteAllBesin()

}
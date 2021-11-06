package com.evirgenoguz.roombootcamp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kitaplık")
data class KitapModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "kitap_ad")
    var kitapAd: String,

    @ColumnInfo(name = "yazar_ad")
    var yazarAd: String
)

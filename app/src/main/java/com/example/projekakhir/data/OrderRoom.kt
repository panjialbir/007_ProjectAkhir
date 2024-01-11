package com.example.projekakhir.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "penyewaan_karaoke")
data class OrderRoom(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val namaPelanggan: String,
    val tanggalSewa: String,
    val durasiSewaJam: Int,
    val hargaTotal: Double
)



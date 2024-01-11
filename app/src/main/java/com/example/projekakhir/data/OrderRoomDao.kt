package com.example.projekakhir.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderRoomDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun tambahPenyewaan(orderRoom: OrderRoom)


    @Update
    suspend fun update(orderRoom: OrderRoom)

    @Delete
    suspend fun delete(orderRoom: OrderRoom)

    @Query("SELECT * from penyewaan_karaoke WHERE id = :id")
    fun getOrder(id: Int): Flow<OrderRoom>

    @Query("SELECT * from penyewaan_karaoke ORDER BY namaPelanggan ASC")
    fun getAllOrder() : Flow<List<OrderRoom>>



}


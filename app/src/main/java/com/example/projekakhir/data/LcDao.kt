package com.example.projekakhir.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface LcDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLC(lc: LC)

    @Query("SELECT * from table_lc ORDER BY lcname ASC") // Ganti someField dengan nama field yang sesuai di LC
    fun getAllLC(): Flow<List<LC>>

    // Fungsi tambahan untuk mendapatkan LC berdasarkan ID
    @Query("SELECT * from table_lc WHERE lcid = :id")
    fun getLC(id: Int): Flow<LC>

    @Delete
    suspend fun deleteLC(lc: LC)

    @Update
    suspend fun updateLC(lc: LC)

}
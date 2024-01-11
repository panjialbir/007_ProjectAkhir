package com.example.projekakhir.repository

import com.example.projekakhir.data.LC
import kotlinx.coroutines.flow.Flow

interface RepositoryLc {
    fun getAllLC(): Flow<List<LC>>

    fun getLC(id: Int): Flow<LC>

    suspend fun insertLC(lc: LC)

    suspend fun deleteLC(lc: LC)

    suspend fun updateLC(lc: LC)
    fun getAllLCStream(): Flow<List<LC>>
    fun getLCStream(id: Int): Flow<LC?>
}
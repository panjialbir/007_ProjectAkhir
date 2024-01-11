package com.example.projekakhir.repository

import com.example.projekakhir.data.LC
import com.example.projekakhir.data.LcDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoryLc(private val lcDao: LcDao) : RepositoryLc {

    override fun getAllLC(): Flow<List<LC>> = lcDao.getAllLC()

    override fun getLC(id: Int): Flow<LC> = lcDao.getLC(id)

    override suspend fun insertLC(lc: LC) = lcDao.insertLC(lc)

    override suspend fun deleteLC(lc: LC) = lcDao.deleteLC(lc)

    override suspend fun updateLC(lc: LC) = lcDao.updateLC(lc)

    override fun getLCStream(id: Int): Flow<LC?> = lcDao.getLC(id)


    override fun getAllLCStream(): Flow<List<LC>> = lcDao.getAllLC()
}

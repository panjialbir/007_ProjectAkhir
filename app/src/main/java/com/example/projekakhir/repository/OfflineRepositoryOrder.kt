package com.example.projekakhir.repository

import com.example.projekakhir.data.OrderRoom
import com.example.projekakhir.data.OrderRoomDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoryOrder(private val orderRoomDao: OrderRoomDao) : RepositoryOrder {
    override fun getAllOrder(): Flow<List<OrderRoom>> = orderRoomDao.getAllOrder()

    override fun getOrder(id: Int): Flow<OrderRoom> = orderRoomDao.getOrder(id)

    override suspend fun insertOrder(orderRoom: OrderRoom) = orderRoomDao.tambahPenyewaan(orderRoom)

    override suspend fun deleteOrder(orderRoom: OrderRoom) = orderRoomDao.delete(orderRoom)

    override suspend fun updateOrder(orderRoom: OrderRoom) = orderRoomDao.update(orderRoom)

    override fun getOrderStream(id: Int): Flow<OrderRoom?> = orderRoomDao.getOrder(id)

    // Implementasi tambahan untuk memenuhi persyaratan RepositoryOrder
    override fun getAllOrderStream(): Flow<List<OrderRoom>> = orderRoomDao.getAllOrder()
}
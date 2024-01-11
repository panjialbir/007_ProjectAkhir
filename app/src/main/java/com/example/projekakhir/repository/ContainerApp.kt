package com.example.projekakhir.repository

import android.content.Context
import com.example.projekakhir.data.DatabaseOrder

interface ContainerApp{

    val repositoryOrder : RepositoryOrder
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoryOrder: RepositoryOrder by lazy {
        OfflineRepositoryOrder(DatabaseOrder.getDatabase(context).orderRoomDao())
    }
}
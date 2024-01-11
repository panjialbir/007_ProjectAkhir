package com.example.projekakhir.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiOrderRoom().container.offlineRepositoryOrder)
        }

        initializer {
            OrderRoomViewModel(aplikasiOrderRoom().container.offlineRepositoryOrder)
        }

        initializer {
            OrderRoomViewModel(aplikasiOrderRoom().container.offlineRepositoryOrder)
        }
    }
}

fun CreationExtras.aplikasiOrderRoom(): AplikasiOrderRoom =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiOrderRoom)
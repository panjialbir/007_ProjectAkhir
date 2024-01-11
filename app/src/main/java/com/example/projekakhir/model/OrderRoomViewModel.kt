package com.example.projekakhir.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.projekakhir.data.OrderRoom
import com.example.projekakhir.repository.OfflineRepositoryOrder

class OrderRoomViewModel(private val repositoryOrder: OfflineRepositoryOrder): ViewModel() {
    var uiStateOrderRoom by mutableStateOf(UIStateOrderRoom())
        private set

    private fun validateInput(uiState: DetailOrderRoom = uiStateOrderRoom.detailOrderRoom): Boolean {
        return with(uiState) {
            namaPelanggan.isNotBlank() && tanggalSewa.isNotBlank() && durasiSewaJam > 0
        }
    }

    fun updateUiState(detailOrderRoom: DetailOrderRoom) {
        uiStateOrderRoom =
            UIStateOrderRoom(detailOrderRoom = detailOrderRoom, isEntryValid = validateInput(detailOrderRoom))
    }

    suspend fun saveOrderRoom() {
        if (validateInput()) {
            repositoryOrder.insertOrder(uiStateOrderRoom.detailOrderRoom.toOrderRoom())
        }
    }
}

data class UIStateOrderRoom(
    val detailOrderRoom: DetailOrderRoom = DetailOrderRoom(),
    val isEntryValid: Boolean = false
)

data class DetailOrderRoom(
    val id: Long = 0,
    val namaPelanggan: String = "",
    val tanggalSewa: String = "",
    val durasiSewaJam: Int = 0,
    val hargaTotal: Double = 0.0
)

fun DetailOrderRoom.toOrderRoom(): OrderRoom = OrderRoom(
    id = id,
    namaPelanggan = namaPelanggan,
    tanggalSewa = tanggalSewa,
    durasiSewaJam = durasiSewaJam,
    hargaTotal = hargaTotal
)

fun OrderRoom.toDetailOrderRoom(): DetailOrderRoom = DetailOrderRoom(
    id = id,
    namaPelanggan = namaPelanggan,
    tanggalSewa = tanggalSewa,
    durasiSewaJam = durasiSewaJam,
    hargaTotal = hargaTotal
)

fun OrderRoom.toUiStateOrderRoom(isEntryValid: Boolean = false): UIStateOrderRoom = UIStateOrderRoom(
    detailOrderRoom = this.toDetailOrderRoom(),
    isEntryValid = isEntryValid
)
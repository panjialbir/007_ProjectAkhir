package com.example.projekakhir.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projekakhir.data.LC
import com.example.projekakhir.data.OrderRoom
import com.example.projekakhir.repository.OfflineRepositoryLc
import com.example.projekakhir.repository.OfflineRepositoryOrder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repositoryOrder: OfflineRepositoryOrder,
    private val repositoryLC: OfflineRepositoryLc
) : ViewModel() {

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    data class HomeUiState(
        val listOrder: List<List<OrderRoom>> = listOf(),
        val listLC: List<List<LC>> = listOf()
    )

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        refreshData()
    }

    private fun refreshData() {
        viewModelScope.launch {
            val orderList = repositoryOrder.getAllOrderStream().filterNotNull().toList()
            val lcList = repositoryLC.getAllLCStream().filterNotNull().toList()

            // Update nilai _homeUiState
            _homeUiState.value = HomeUiState(listOrder = orderList, listLC = lcList)
        }
    }
}
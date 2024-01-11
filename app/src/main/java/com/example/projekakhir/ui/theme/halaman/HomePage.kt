package com.example.projekakhir.ui.theme.halaman

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.projekakhir.R
import com.example.projekakhir.model.HomeViewModel
import com.example.projekakhir.model.PenyediaViewModel
import com.example.projekakhir.navigasi.DestinasiNavigasi

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = R.string.app_name
}
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(
    navigateToAddLC: () -> Unit,
    navigateToOrderRoom: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val uiStateLC by viewModel.homeUiStateLC.collectAsState()
    val uiStateOrderRoom by viewModel.homeUiState.collectAsState()

    Scaffold(
        modifier = modifier,
        topBar = {
            // ... sesuai kebutuhan
        },
        floatingActionButton = {
            Row {
                FloatingActionButton(
                    onClick = navigateToAddLC,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.lc)
                    )
                }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                FloatingActionButton(
                    onClick = navigateToOrderRoom,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.entry_order_room)
                    )
                }
            }
        }
    ) { innerPadding ->
        // Gunakan uiStateLC dan uiStateOrderRoom sesuai kebutuhan
        BodyHome(
            itemLC = uiStateLC.listLC,
            itemOrderRoom = uiStateOrderRoom.listOrderRoom,
            modifier = Modifier.padding(innerPadding).fillMaxSize()
        )
    }
}

@Composable
fun BodyHome(itemLC: Any, itemOrderRoom: Any, modifier: Modifier) {

}

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.projekakhir.ui.theme.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.projekakhir.R
import com.example.projekakhir.model.DetailOrderRoom
import com.example.projekakhir.model.UIStateOrderRoom
import com.example.projekakhir.navigasi.DestinasiNavigasi

object DestinasiEntry: DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = R.string.ordernow
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryOrderRoomBody(
    uiStateOrderRoom: UIStateOrderRoom,
    onOrderRoomValueChange: (DetailOrderRoom) -> Unit,
    onSaveOrderRoomClick: () -> Unit,
    onAddLCClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        FormInputOrderRoom(
            detailOrderRoom = uiStateOrderRoom.detailOrderRoom,
            onValueChange = onOrderRoomValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveOrderRoomClick,
            enabled = uiStateOrderRoom.isEntryValid,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(id = R.string.btn_submit_order_room))
        }

        // Tombol untuk menambahkan LC
        Button(
            onClick = onAddLCClick,
            enabled = true, // Sesuaikan dengan kondisi yang sesuai
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(id = R.string.add_lc))
        }
    }
}

@Composable
fun FormInputOrderRoom(
    detailOrderRoom: DetailOrderRoom,
    modifier: Modifier = Modifier,
    onValueChange: (DetailOrderRoom) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
    ) {
        // Sesuaikan dengan entitas OrderRoom (nama, tanggal, durasi, harga, dll.)
        OutlinedTextField(
            value = detailOrderRoom.namaPelanggan,
            onValueChange = { onValueChange(detailOrderRoom.copy(namaPelanggan = it)) },
            label = { Text(stringResource(id = R.string.namaPelanggan)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = detailOrderRoom.tanggalSewa,
            onValueChange = { onValueChange(detailOrderRoom.copy(tanggalSewa = it)) },
            label = { Text(stringResource(id = R.string.tanggalSewa)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        // Tambahkan field lainnya sesuai kebutuhan
        // ...
        val onSaveOrderRoomClick = null
        val uiStateOrderRoom = null
        fun EntryOrderRoomBody(
            uiStateOrderRoom: UIStateOrderRoom,
            onOrderRoomValueChange: (DetailOrderRoom) -> Unit,
            onSaveOrderRoomClick: () -> Unit,
            onAddLCClick: () -> Unit,
            modifier: Modifier = Modifier
        ) {
            // ...
            Button(
                onClick = onSaveOrderRoomClick,
                enabled = uiStateOrderRoom.isEntryValid,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(id = R.string.btn_submit_order_room))
            }
        }
    }
}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.projekakhir.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projekakhir.R
import com.example.projekakhir.ui.theme.halaman.HomeScreen

@Composable
fun KaraokeApp(navController: NavHostController = rememberNavController()){
    KaraokeHostNavigasi(navController = navController)
}

@Composable
fun KaraokeTopAppBar(
    title: String,
    canNavigateback: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = { Text(title) },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateback){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.cncl)
                    )
                }
            }
        }
    )
}

@Composable
fun KaraokeHostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController = navController, startDestination = DestinasiNavigasi.route, modifier = modifier)
    {
        composable(DestinasiNavigasi.route){
            HomeScreen(
                navigateToAddLC = { navController.navigate(DestinasiAddLC.route) },
                navigateToOrderRoom = { navController.navigate(DestinasiOrderRoom.route) }
            )
        }
        composable(DestinasiLC.route){
            AddLCEntryScreen(navigateBack = { navController.popBackStack() })
        }
        composable(DestinasiOrderRoom.route){
            OrderRoomEntryScreen(navigateBack = { navController.popBackStack() })
        }
    }
}

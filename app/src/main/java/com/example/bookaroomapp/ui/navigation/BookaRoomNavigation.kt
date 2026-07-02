package com.example.bookaroomapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookaroomapp.ui.screen.LoginScreen
import com.example.bookaroomapp.ui.screen.RoomCatalogScreen

@Composable
fun BookaRoomNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        // Halaman Login
        composable(Screen.Login.route) {
            LoginScreen(
                modifier,
                onLoginSuccess = {
                    // Berpindah ke halaman Katalog Kamar
                    navController.navigate(Screen.RoomCatalog.route) {
                        // Opsi Tambahan: Menghapus LoginScreen dari Backstack
                        // Agar ketika pengguna menekan tombol kembali (back), mereka tidak masuk lagi ke layar login.
                        popUpTo(Screen.Login.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Halaman Katalog Kamar
        composable(Screen.RoomCatalog.route) {
            RoomCatalogScreen(modifier)
        }
    }
}
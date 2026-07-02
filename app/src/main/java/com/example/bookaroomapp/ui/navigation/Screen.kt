package com.example.bookaroomapp.ui.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object RoomCatalog : Screen("room_catalog")
}
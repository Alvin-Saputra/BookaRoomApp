package com.example.bookaroomapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookaroomapp.model.Room
import com.example.bookaroomapp.ui.component.RoomCard

@Composable
fun RoomCatalogScreen(modifier: Modifier = Modifier) {
    // Mengambil data dummy dari model Room
    val rooms = Room.dummyRoom

    // LazyVerticalGrid akan otomatis menyusun kartu ke samping lalu ke bawah (seperti grid)
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 140.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(rooms) { room ->
            RoomCard(room = room)
        }
    }
}

@Composable
@Preview
fun RoomCatalogScreenPreview() {
    // Sebaiknya gunakan BookaRoomAppTheme jika Anda sudah memilikinya,
    // Jika belum, MaterialTheme bawaan sudah cukup.
    MaterialTheme {
        RoomCatalogScreen()
    }
}
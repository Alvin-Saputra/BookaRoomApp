package com.example.bookaroomapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookaroomapp.ui.component.RoomCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun RoomCatalogScreen(
    modifier: Modifier = Modifier,
    viewModel: RoomViewModel = koinViewModel() // Inject ViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    // Trigger pemanggilan API saat pertama kali layar dibuka
    LaunchedEffect(Unit) {
        // PERHATIAN: Masukkan Token JWT Anda yang valid di sini untuk percobaan
        viewModel.getRooms("TOKEN_JWT_DARI_LOGIN")
    }

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (val state = uiState) {
            is RoomUiState.Loading -> {
                CircularProgressIndicator() // Menampilkan loading spinner
            }
            is RoomUiState.Error -> {
                Text(
                    text = state.message,
                    color = MaterialTheme.colorScheme.error
                )
            }
            is RoomUiState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 140.dp),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.rooms) { room ->
                        RoomCard(room = room)
                    }
                }
            }
        }
    }
}
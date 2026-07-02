package com.example.bookaroomapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookaroomapp.domain.model.Room
import com.example.bookaroomapp.repository.RoomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Menyimpan status state layar
sealed class RoomUiState {
    object Loading : RoomUiState()
    data class Success(val rooms: List<Room>) : RoomUiState()
    data class Error(val message: String) : RoomUiState()
}

class RoomViewModel(private val repository: RoomRepository) : ViewModel() {

    private val _uiState = MutableStateFlow<RoomUiState>(RoomUiState.Loading)
    val uiState: StateFlow<RoomUiState> = _uiState.asStateFlow()

    fun getRooms(token: String) {
        viewModelScope.launch {
            _uiState.value = RoomUiState.Loading
            try {
                val rooms = repository.fetchRooms(token)
                _uiState.value = RoomUiState.Success(rooms)
            } catch (e: Exception) {
                _uiState.value = RoomUiState.Error(e.message ?: "Terjadi kesalahan")
            }
        }
    }
}
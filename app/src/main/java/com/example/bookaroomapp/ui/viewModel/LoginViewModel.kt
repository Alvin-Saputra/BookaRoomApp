package com.example.bookaroomapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookaroomapp.data.local.UserPreferences
import com.example.bookaroomapp.data.repository.LoginRepository
import com.example.bookaroomapp.data.repository.LoginResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    data class Success(val message: String) : LoginUiState()
    data class Error(val message: String) : LoginUiState()
}

class LoginViewModel(
    private val repository: LoginRepository,
    private val userPreferences: UserPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = LoginUiState.Loading

            // Memanggil fungsi login dari repository
            when (val result = repository.login(email, password)) {
                is LoginResult.Success -> {
                    // Simpan token ketika berhasil login
                    userPreferences.saveToken(result.token)
                    _uiState.value = LoginUiState.Success(result.message)
                }
                is LoginResult.Error -> {
                    _uiState.value = LoginUiState.Error(result.message)
                }
            }
        }
    }
}
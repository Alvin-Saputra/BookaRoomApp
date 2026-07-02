package com.example.bookaroomapp.ui.viewModel

import com.example.bookaroomapp.data.repository.LoginRepository
import com.example.bookaroomapp.data.repository.LoginResult

class LoginViewModel(private val repository: LoginRepository) {

    suspend fun login(email: String, password: String): LoginResult {
        return repository.login(email, password)
    }
}

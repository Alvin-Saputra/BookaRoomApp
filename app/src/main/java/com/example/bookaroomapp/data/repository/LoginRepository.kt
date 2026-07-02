package com.example.bookaroomapp.data.repository

import ErrorResponse
import com.example.bookaroomapp.data.remote.request.LoginRequest
import com.example.bookaroomapp.network.ApiService
import com.google.gson.Gson
import java.io.IOException

val errorMessages = mapOf(
    "ERR_NOT_FOUND" to "The room you are looking for no longer exists or has been deleted.",
    "ERR_MISSING_FIELDS" to "Please fill in all required fields before saving.",
    "ERR_DATABASE" to "Our server is currently experiencing an issue. Please try again later.",
    "ERR_CREATE_FAILED" to "Failed to save the new room to the system."
)

sealed class LoginResult {

    data class Success(
        val message: String,
        val token: String
    ) : LoginResult()

    data class Error(
        val message: String
    ) : LoginResult()
}

class LoginRepository(private val apiService: ApiService) {
    suspend fun login(email: String, password: String): LoginResult {
        return try {

            val response = apiService.login(LoginRequest(email, password))

            if (response.isSuccessful) {
                LoginResult.Success(
                    message = response.body()?.message ?: "",
                    token = response.body()?.data?.token ?: ""
                )
            } else {
                val error = try {
                    Gson().fromJson(
                        response.errorBody()?.charStream(),
                        ErrorResponse::class.java
                    )
                } catch (e: Exception) {
                    null
                }

                val message = error?.errorCode?.let {
                    errorMessages[it]
                } ?: error?.message ?: "Terjadi kesalahan."

                LoginResult.Error(message)
            }

        } catch (e: IOException) {
            LoginResult.Error("Tidak ada koneksi internet.")
        } catch (e: Exception) {
            LoginResult.Error("Terjadi kesalahan pada aplikasi.")
        }
    }
}
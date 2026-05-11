package com.example.bookaroomapp.network

import com.example.bookaroomapp.data.remote.response.RoomResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    // Karena backend Anda membutuhkan Bearer Token
    @GET("rooms")
    suspend fun getRooms(
        @Header("Authorization") token: String
    ): Response<RoomResponse>
}
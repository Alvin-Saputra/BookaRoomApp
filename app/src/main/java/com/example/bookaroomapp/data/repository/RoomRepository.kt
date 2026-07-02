package com.example.bookaroomapp.repository

import com.example.bookaroomapp.domain.model.Room
import com.example.bookaroomapp.network.ApiService

class RoomRepository(private val apiService: ApiService) {

    suspend fun fetchRooms(token: String): List<Room> {
        val response = apiService.getRooms("Bearer $token")
        if (response.isSuccessful) {
            // Ambil data dari response dan ubah DTO menjadi model Room
            return response.body()?.data?.filterNotNull()?.map { it.toDomain() } ?: emptyList()
        } else {
            throw Exception("Gagal mengambil data: ${response.code()}")
        }
    }

}
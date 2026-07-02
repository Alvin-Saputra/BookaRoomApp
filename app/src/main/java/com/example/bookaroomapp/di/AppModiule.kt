

package com.example.bookaroomapp.di

import com.example.bookaroomapp.data.remote.network.ApiClient
import com.example.bookaroomapp.repository.RoomRepository
import com.example.bookaroomapp.ui.screen.RoomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module() {
    // single = membuat instance Singleton (hanya 1 untuk seluruh aplikasi)
    single { ApiClient.instance }

    // get() = Koin akan otomatis mencari tipe data yang dibutuhkan (di sini ApiService/ApiClient)
    single { RoomRepository(get()) }

    // viewModel = khusus untuk inisialisasi ViewModel
    viewModel { RoomViewModel(get()) }
}
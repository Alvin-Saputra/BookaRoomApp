

package com.example.bookaroomapp.di

import com.example.bookaroomapp.data.local.UserPreferences
import com.example.bookaroomapp.data.remote.network.ApiClient
import com.example.bookaroomapp.data.repository.LoginRepository
import com.example.bookaroomapp.repository.RoomRepository
import com.example.bookaroomapp.ui.viewModel.LoginViewModel
import com.example.bookaroomapp.ui.viewModel.RoomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module() {
    // single = membuat instance Singleton (hanya 1 untuk seluruh aplikasi)
    single { ApiClient.instance }
    single { UserPreferences(get()) }

    // get() = Koin akan otomatis mencari tipe data yang dibutuhkan (di sini ApiService/ApiClient)
    single { RoomRepository(get()) }
    single { LoginRepository(get()) }

    // viewModel = khusus untuk inisialisasi ViewModel
    viewModel { RoomViewModel(get()) }
    viewModel { LoginViewModel(get(), get()) }
}

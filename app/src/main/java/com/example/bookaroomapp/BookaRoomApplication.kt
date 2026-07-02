package com.example.bookaroomapp

import android.app.Application
import com.example.bookaroomapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BookaRoomApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Memberikan context aplikasi ke Koin (jika dibutuhkan oleh database/sharedpref)
            androidContext(this@BookaRoomApplication)
            // Memuat module yang sudah kita buat tadi
            modules(appModule)
        }
    }
}
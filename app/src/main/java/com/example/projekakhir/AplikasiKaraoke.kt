package com.example.projekakhir

import android.app.Application
import com.example.projekakhir.repository.ContainerApp
import com.example.projekakhir.repository.ContainerDataApp

class AplikasiKaraoke: Application() {


        lateinit var container: ContainerApp

        override fun onCreate() {
            super.onCreate()
            container = ContainerDataApp(this)
        }
    }

package com.example.repositorypatternwithhilt.ui

import android.app.Application
import com.example.repositorypatternwithhilt.di.appModule
import com.example.repositorypatternwithhilt.di.cacheModule
import com.example.repositorypatternwithhilt.di.networkModule
import com.example.repositorypatternwithhilt.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(listOf(appModule, cacheModule, networkModule, repositoryModule))
        }
    }

}
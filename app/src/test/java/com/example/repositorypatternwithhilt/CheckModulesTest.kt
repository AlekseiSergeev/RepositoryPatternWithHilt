package com.example.repositorypatternwithhilt

import android.app.Application
import com.example.repositorypatternwithhilt.di.appModule
import com.example.repositorypatternwithhilt.di.cacheModule
import com.example.repositorypatternwithhilt.di.networkModule
import com.example.repositorypatternwithhilt.di.repositoryModule
import io.mockk.mockk
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules

class CheckModulesTest : KoinTest {

    private val mockApplication: Application = mockk()

    @Test
    fun verifyKoinApp() {
        koinApplication {
            modules(listOf(appModule, cacheModule, networkModule, repositoryModule))
            checkModules {
                withInstance(androidContext(mockApplication))
            }
        }
    }

}
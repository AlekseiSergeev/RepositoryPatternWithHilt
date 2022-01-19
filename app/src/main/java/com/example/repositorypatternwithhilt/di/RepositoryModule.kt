package com.example.repositorypatternwithhilt.di

import com.example.repositorypatternwithhilt.data.cache.mappers.CacheMapper
import com.example.repositorypatternwithhilt.data.network.mappers.NetworkMapper
import com.example.repositorypatternwithhilt.repository.MainRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { NetworkMapper() }
    single { CacheMapper() }
    single { MainRepository(get(), get(), get(), get()) }
}

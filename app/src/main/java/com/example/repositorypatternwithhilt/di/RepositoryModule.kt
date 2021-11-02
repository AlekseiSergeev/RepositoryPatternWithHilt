package com.example.repositorypatternwithhilt.di

import com.example.repositorypatternwithhilt.repository.MainRepository
import com.example.repositorypatternwithhilt.data.network.retrofit.BlogRetrofit
import com.example.repositorypatternwithhilt.data.network.mappers.NetworkMapper
import com.example.repositorypatternwithhilt.data.cache.database.BlogDao
import com.example.repositorypatternwithhilt.data.cache.mappers.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}
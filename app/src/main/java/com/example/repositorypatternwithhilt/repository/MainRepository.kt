package com.example.repositorypatternwithhilt.repository

import com.example.repositorypatternwithhilt.domain.model.Blog
import com.example.repositorypatternwithhilt.data.network.retrofit.BlogRetrofit
import com.example.repositorypatternwithhilt.data.network.mappers.NetworkMapper
import com.example.repositorypatternwithhilt.data.cache.database.BlogDao
import com.example.repositorypatternwithhilt.data.cache.mappers.CacheMapper
import com.example.repositorypatternwithhilt.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository
constructor(
    private val blogDao: BlogDao,
    private val blogRetrofit: BlogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getBlog(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val networkBlogs = blogRetrofit.getBlogs()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for(blog in blogs){
                blogDao.insert(cacheMapper.mapToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))

        } catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}
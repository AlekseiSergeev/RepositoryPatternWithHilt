package com.example.repositorypatternwithhilt.data.network.retrofit

import com.example.repositorypatternwithhilt.data.network.model.BlogNetworkEntity
import retrofit2.http.GET

interface BlogRetrofit {
    @GET("blogs")
    suspend fun getBlogs() : List<BlogNetworkEntity>
}
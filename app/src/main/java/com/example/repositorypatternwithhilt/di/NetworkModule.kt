package com.example.repositorypatternwithhilt.di

import com.example.repositorypatternwithhilt.data.network.retrofit.BlogRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideBlogService(provideRetrofitBuilder(provideGsonBuilder())) }
}

fun provideGsonBuilder(): Gson {
    return GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create()
}

fun provideRetrofitBuilder(gson: Gson): Retrofit.Builder {
    return Retrofit.Builder()
        .baseUrl("https://open-api.xyz/placeholder/")
        .addConverterFactory(GsonConverterFactory.create(gson))
}

fun provideBlogService(retrofit: Retrofit.Builder): BlogRetrofit {
    return retrofit
        .build()
        .create(BlogRetrofit::class.java)
}

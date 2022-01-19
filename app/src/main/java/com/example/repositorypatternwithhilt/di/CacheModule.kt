package com.example.repositorypatternwithhilt.di

import android.content.Context
import androidx.room.Room
import com.example.repositorypatternwithhilt.data.cache.database.BlogDao
import com.example.repositorypatternwithhilt.data.cache.database.BlogDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheModule = module {
    single { provideBlogDao(provideBlogDb(androidContext())) }
}

fun provideBlogDb(context: Context): BlogDatabase {
    return Room.databaseBuilder(
        context,
        BlogDatabase::class.java,
        BlogDatabase.DATABASE_NAME
    )
        .fallbackToDestructiveMigration()
        .build()
}

fun provideBlogDao(blogDatabase: BlogDatabase): BlogDao {
    return blogDatabase.blogDao()
}

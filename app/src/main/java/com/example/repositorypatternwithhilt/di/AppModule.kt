package com.example.repositorypatternwithhilt.di

import com.example.repositorypatternwithhilt.ui.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val appModule = module {
    viewModel { MainViewModel(get()) }
}

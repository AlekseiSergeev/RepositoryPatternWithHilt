package com.example.repositorypatternwithhilt.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainFragmentFactory
constructor() : FragmentFactory() {

    @ExperimentalCoroutinesApi
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            MainFragment::class.java.name -> {
                MainFragment()
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}
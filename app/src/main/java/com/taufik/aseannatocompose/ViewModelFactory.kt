package com.taufik.aseannatocompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taufik.aseannatocompose.data.CountryRepository
import com.taufik.aseannatocompose.ui.screen.detail.DetailViewModel
import com.taufik.aseannatocompose.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: CountryRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(repository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
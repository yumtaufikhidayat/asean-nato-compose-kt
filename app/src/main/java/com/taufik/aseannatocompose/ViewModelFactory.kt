package com.taufik.aseannatocompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taufik.aseannatocompose.data.CountryRepository
import com.taufik.aseannatocompose.ui.CountryViewModel

class ViewModelFactory(private val repository: CountryRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CountryViewModel::class.java) -> CountryViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
package com.taufik.aseannatocompose.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.taufik.aseannatocompose.data.CountryRepository
import com.taufik.aseannatocompose.model.Country
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CountryViewModel(private val repository: CountryRepository): ViewModel() {
    private val _groupedCountries = MutableStateFlow(
        repository.getCountries()
            .sortedBy { it.countryName }
            .groupBy { it.countryName[0] }
    )
    val groupedCountries: StateFlow<Map<Char, List<Country>>> get() = _groupedCountries
    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedCountries.value = repository.searchCountries(_query.value)
            .sortedBy { it.countryName }
            .groupBy { it.countryName[0] }
    }
}
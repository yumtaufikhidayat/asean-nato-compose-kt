package com.taufik.aseancompose.data

import com.taufik.aseancompose.model.Country
import com.taufik.aseancompose.model.FakeCountryDataSource

class CountryRepository {
    fun getCountries(): List<Country> = FakeCountryDataSource.dummyCountries
    fun searchCountries(query: String): List<Country> {
        return FakeCountryDataSource.dummyCountries.filter {
            it.countryName.contains(query, ignoreCase = true)
        }
    }
}
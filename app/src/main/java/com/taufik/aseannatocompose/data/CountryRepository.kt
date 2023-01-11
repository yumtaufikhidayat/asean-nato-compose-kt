package com.taufik.aseannatocompose.data

import com.taufik.aseannatocompose.model.Country
import com.taufik.aseannatocompose.model.FakeCountryDataSource

class CountryRepository {
    fun getCountries(): List<Country> = FakeCountryDataSource.dummyCountries
    fun searchCountries(query: String): List<Country> {
        return FakeCountryDataSource.dummyCountries.filter {
            it.countryName.contains(query, ignoreCase = true)
        }
    }
}
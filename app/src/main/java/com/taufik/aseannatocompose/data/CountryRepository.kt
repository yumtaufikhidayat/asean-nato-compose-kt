package com.taufik.aseannatocompose.data

import com.taufik.aseannatocompose.model.Country
import com.taufik.aseannatocompose.model.FakeCountryDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CountryRepository {

    private val countries = mutableListOf<Country>()

    init {
        if (countries.isEmpty()) {
            FakeCountryDataSource.dummyCountries.forEach {
                countries.add(
                    Country(
                        it.countryId,
                        it.countryName,
                        it.countryInternationalName,
                        it.countryFlagUrl,
                        it.countryDescription,
                        it.countryHeadGovernment,
                        it.countryCapital,
                        it.countryIndependenceDay,
                        it.countryLanguage,
                        it.countryCurrency,
                        it.countryLandArea
                    )
                )
            }
        }
    }

    fun getAllCountries(): Flow<List<Country>> = flowOf(countries)

    fun getCountryById(detailId: Int): Country {
        return countries.first {
            it.countryId == detailId
        }
    }

    companion object {
        @Volatile
        private var instance: CountryRepository? = null

        fun getInstance(): CountryRepository =
            instance ?: synchronized(this) {
                CountryRepository().apply {
                    instance = this
                }
            }
    }
}
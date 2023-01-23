package com.taufik.aseannatocompose.di

import com.taufik.aseannatocompose.data.CountryRepository

object Injection {
    fun provideRepository(): CountryRepository {
        return CountryRepository.getInstance()
    }
}
package com.taufik.aseannatocompose.ui.screen.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.taufik.aseannatocompose.ViewModelFactory
import com.taufik.aseannatocompose.di.Injection
import com.taufik.aseannatocompose.model.Country
import com.taufik.aseannatocompose.ui.common.UiState
import com.taufik.aseannatocompose.ui.components.CountryListItem

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> viewModel.getAllCountries()
            is UiState.Success -> {
                HomeContent(
                    listOfCountries = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
private fun HomeContent(
    listOfCountries: List<Country>,
    modifier: Modifier,
    navigateToDetail: (Int) -> Unit
) {
    LazyColumn {
        items(listOfCountries) { data ->
            CountryListItem(
                countryId = data.countryId,
                countryName = data.countryName,
                countryInternationalName = data.countryInternationalName,
                countryFlagUrl = data.countryFlagUrl,
                countryDescription = data.countryDescription,
                countryHeadGovernment = data.countryHeadGovernment,
                countryCapital = data.countryCapital,
                countryIndependenceDay = data.countryIndependenceDay,
                countryLanguage = data.countryLanguage,
                countryCurrency = data.countryCurrency,
                countryLandArea = data.countryLandArea,
                modifier = modifier,
                navigateToDetail = navigateToDetail
            )
        }
    }
}
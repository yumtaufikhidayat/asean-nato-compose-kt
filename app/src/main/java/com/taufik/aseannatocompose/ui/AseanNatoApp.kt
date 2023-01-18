package com.taufik.aseannatocompose.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.taufik.aseannatocompose.ViewModelFactory
import com.taufik.aseannatocompose.data.CountryRepository
import com.taufik.aseannatocompose.ui.components.*
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AseanNatoApp(
    modifier: Modifier = Modifier,
    viewModel: CountryViewModel = viewModel(factory = ViewModelFactory(CountryRepository()))
) {
    val groupedCountries by viewModel.groupedCountries.collectAsState()
    val query by viewModel.query

    Box(modifier = modifier) {
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
        val showButton by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            item {
                ToolbarHeader(
                    title = "ASEAN-NATO Countries",
                )
                SearchBar(
                    query = query,
                    onQueryChange = viewModel::search,
                    modifier = Modifier.background(MaterialTheme.colors.primaryVariant)
                )
            }
            groupedCountries.forEach { (initial, countries) ->
                stickyHeader {
                    CountriesHeader(char = initial)
                }
                items(countries, key = { it.countryId} ) { country ->
                    CountryListItem(
                        countryId = country.countryId,
                        countryName = country.countryName,
                        countryInternationalName = country.countryInternationalName,
                        countryFlagUrl = country.countryFlagUrl,
                        countryCapital = country.countryCapital,
                        countryIndependenceDay = country.countryIndependenceDay,
                        countryDescription = country.countryDescription,
                        countryCurrency = country.countryCurrency,
                        countryHeadGovernment = country.countryHeadGovernment,
                        countryLandArea = country.countryLandArea,
                        countryLanguage = country.countryLanguage,
                        isShow = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateItemPlacement(tween(durationMillis = 100)),
                    )
                }
            }
        }

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically(),
            modifier = Modifier
                .padding(bottom = 30.dp)
                .align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(onClick = {
                scope.launch {
                    listState.scrollToItem(index = 0)
                }
            })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun AseanNatoAppPreview() {
    AseanNatoComposeTheme {
        AseanNatoApp()
    }
}
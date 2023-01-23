package com.taufik.aseannatocompose.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taufik.aseannatocompose.data.CountryRepository
import com.taufik.aseannatocompose.model.Country
import com.taufik.aseannatocompose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: CountryRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Country>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Country>>>
        get() = _uiState

    fun getAllCountries() {
        viewModelScope.launch {
            repository.getAllCountries()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }
}
package com.taufik.aseannatocompose.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taufik.aseannatocompose.data.CountryRepository
import com.taufik.aseannatocompose.model.Country
import com.taufik.aseannatocompose.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: CountryRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Country>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Country>>
        get() = _uiState

    fun getCountryById(detailId: Int) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getCountryById(detailId))
        }
    }
}
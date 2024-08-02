package com.fermers_marketplace.unsplash2_0.ui.search_screen

import com.fermers_marketplace.unsplash2_0.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SearchViewModel @Inject constructor(
) : BaseViewModel() {

    private val _queryFLow = MutableStateFlow("")
    val queryFlow: StateFlow<String> = _queryFLow.asStateFlow()

}
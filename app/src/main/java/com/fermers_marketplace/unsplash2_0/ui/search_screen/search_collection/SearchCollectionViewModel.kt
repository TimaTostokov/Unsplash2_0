package com.fermers_marketplace.unsplash2_0.ui.search_screen.search_collection

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.fermers_marketplace.unsplash2_0.data.paging.SearchCollectionPagingSource
import com.fermers_marketplace.unsplash2_0.domain.repository.SearchRepository
import com.fermers_marketplace.unsplash2_0.domain.usecase.search_usecase.SearchCollectionParam
import com.fermers_marketplace.unsplash2_0.ui.base.BaseViewModel
import javax.inject.Inject

class SearchCollectionViewModel @Inject constructor(private val searchRepository: SearchRepository) :
    BaseViewModel() {
    private var param = SearchCollectionParam("", 1)

    val searchCollectionsList = Pager(
        PagingConfig(
            pageSize = 10,
            prefetchDistance = 5,
            enablePlaceholders = true,
            initialLoadSize = 10
        )
    ) {
        SearchCollectionPagingSource(
            searchRepository = searchRepository,
            query = param.query
        )
    }.flow.cachedIn(viewModelScope)

    fun setArgs(query: String) {
        if (param.query != query) {
            param = param.copy(query = query)
        }
    }
}
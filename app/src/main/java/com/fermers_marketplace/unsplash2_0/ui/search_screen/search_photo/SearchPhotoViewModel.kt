package com.fermers_marketplace.unsplash2_0.ui.search_screen.search_photo

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.fermers_marketplace.unsplash2_0.data.paging.SearchPhotoPagingSource
import com.fermers_marketplace.unsplash2_0.domain.repository.SearchRepository
import com.fermers_marketplace.unsplash2_0.domain.usecase.search_usecase.SearchPhotoParam
import com.fermers_marketplace.unsplash2_0.ui.base.BaseViewModel
import javax.inject.Inject

class SearchPhotoViewModel @Inject constructor(private val searchRepository: SearchRepository) :
    BaseViewModel() {

    private var param =
        SearchPhotoParam(
            "",
            1,
            OrderSearchPhoto.LATEST,
            ContentFilterSearchPhoto.LOW,
            ColorSearchPhoto.BLACK,
            OrientationSearchPhoto.LANDSCAPE
        )
    val searchPhotosList = Pager(
        PagingConfig(
            pageSize = 10,
            prefetchDistance = 5,
            enablePlaceholders = true,
            initialLoadSize = 10
        )
    ) {
        SearchPhotoPagingSource(
            searchRepository = searchRepository,
            query = param.query,
            orderBy = param.orderBy.value,
            contentFilter = param.contentFilter.value,
            color = param.color?.value,
            orientation = param.orientation?.value,
        )
    }.flow.cachedIn(viewModelScope)

    fun setArgs(query: String) {
        if (param.query != query) {
            param = param.copy(query = query)
        }
    }
}
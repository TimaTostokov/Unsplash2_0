package com.fermers_marketplace.unsplash2_0.ui.collection_screens

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.usecase.collection_usecase.GetCollectionUseCase
import com.fermers_marketplace.unsplash2_0.ui.base.BaseViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CollectionViewModel @Inject constructor(
    getCollectionUseCase: GetCollectionUseCase
) : BaseViewModel() {

    val listCollection: Flow<PagingData<CollectionDto>> =
        getCollectionUseCase.executePagingCollection()
            .cachedIn(viewModelScope)
}
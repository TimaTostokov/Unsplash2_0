package com.fermers_marketplace.unsplash2_0.domain.repository

import androidx.paging.PagingData
import com.fermers_marketplace.unsplash2_0.domain.model.Collection
import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import kotlinx.coroutines.flow.Flow

/**
 * Репозиторий для коллекций
 */
interface CollectionRepository {
    suspend fun getListCollections(page: Int): List<Collection>

    suspend fun getDataBaseListCollections(page: Int): List<Collection>

    fun getPagingCollection(): Flow<PagingData<CollectionDto>>
}
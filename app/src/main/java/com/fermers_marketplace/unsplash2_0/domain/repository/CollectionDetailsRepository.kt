package com.fermers_marketplace.unsplash2_0.domain.repository

import com.fermers_marketplace.unsplash2_0.domain.model.CollectionDetails
import com.fermers_marketplace.unsplash2_0.domain.model.CollectionPhotos

/**
 * Репозиторий для информации о коллекции
 */
interface CollectionDetailsRepository {

    suspend fun getCollectionDetails(collectionId: String): CollectionDetails

    suspend fun getListCollectionPhotos(collectionId: String, page: Int): List<CollectionPhotos>
}
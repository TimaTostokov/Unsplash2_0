package com.fermers_marketplace.unsplash2_0.data.repository

import com.fermers_marketplace.unsplash2_0.domain.model.CollectionDetails
import com.fermers_marketplace.unsplash2_0.domain.model.CollectionPhotos
import com.fermers_marketplace.unsplash2_0.domain.repository.CollectionDetailsRepository
import com.fermers_marketplace.unsplash2_0.services.apiservices.UnsplashApiService
import javax.inject.Inject

/**
 * Имплементация [CollectionDetailsRepository]
 */
class CollectionDetailsRepositoryImpl @Inject constructor(private val unsplashApiService: UnsplashApiService) :
    CollectionDetailsRepository {

    override suspend fun getCollectionDetails(collectionId: String): CollectionDetails =
        unsplashApiService.getCollectionDetails(collectionId)

    override suspend fun getListCollectionPhotos(
        collectionId: String,
        page: Int
    ): List<CollectionPhotos> =
        unsplashApiService.getCollectionPhotos(collectionId, page, 10)
}
package com.fermers_marketplace.unsplash2_0.domain.usecase.collection_details

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.CollectionDetails
import com.fermers_marketplace.unsplash2_0.domain.repository.CollectionDetailsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Получение информаании о коллекции
 */
class GetCollectionDetailsUseCase @Inject constructor(private val collectionDetailsRepository: CollectionDetailsRepository) :
    UseCase<String, CollectionDetails>(Dispatchers.IO) {

    override suspend fun execute(collectionId: String): CollectionDetails =
        collectionDetailsRepository.getCollectionDetails(collectionId)
}
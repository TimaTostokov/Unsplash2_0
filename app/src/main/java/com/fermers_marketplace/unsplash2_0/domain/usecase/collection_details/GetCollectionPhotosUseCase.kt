package com.fermers_marketplace.unsplash2_0.domain.usecase.collection_details

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.CollectionPhotos
import com.fermers_marketplace.unsplash2_0.domain.repository.CollectionDetailsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

data class ParamCollectionPhotos(
    val id: String,
    val page: Int
)

/**
 * Получение списка фотографий коллекций
 */
class GetCollectionPhotosUseCase @Inject constructor(private val collectionDetailsRepository: CollectionDetailsRepository) :
    UseCase<ParamCollectionPhotos, List<CollectionPhotos>>(Dispatchers.IO) {
    override suspend fun execute(param: ParamCollectionPhotos): List<CollectionPhotos> =
        collectionDetailsRepository.getListCollectionPhotos(param.id, param.page)
}
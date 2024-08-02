package com.fermers_marketplace.unsplash2_0.domain.usecase.collection_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.Collection
import com.fermers_marketplace.unsplash2_0.domain.repository.CollectionRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Получение списка коллекций
 */
class GetCollectionUseCase @Inject constructor(
    private val collectionRepository: CollectionRepository
) : UseCase<Int, List<Collection>>(Dispatchers.IO) {

    /**
     * @see UseCase.execute
     */
    override suspend fun execute(param: Int): List<Collection> =
        collectionRepository.getListCollections(param)

    fun executePagingCollection() = collectionRepository.getPagingCollection()
}
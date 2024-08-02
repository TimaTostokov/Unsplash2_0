package com.fermers_marketplace.unsplash2_0.data.repository

import com.fermers_marketplace.unsplash2_0.db.CollectionDao
import com.fermers_marketplace.unsplash2_0.domain.model.Collection
import com.fermers_marketplace.unsplash2_0.domain.repository.CollectionRepository
import com.fermers_marketplace.unsplash2_0.services.apiservices.UnsplashApiService
import javax.inject.Inject

/**
 * Имплементация [CollectionRepository]
 */
class CollectionRepositoryImpl @Inject constructor(
    private val unsplashApiService: UnsplashApiService,
    private val collectionDao: CollectionDao
) : CollectionRepository {

    /**
     * Получает список коллекций с сервера
     * @param page - страница из 10 элементов
     */
    override suspend fun getListCollections(page: Int): List<Collection> {
        val collections = unsplashApiService.getCollections(page, 10).map { collection ->
            Collection(
                id = collection.id,
                userName = collection.user.name.toString(),
                profileImage = collection.user.profileImage?.medium.toString(),
                title = collection.title,
                urls = collection.coverPhoto.url?.regular.toString(),
                totalPhoto = collection.totalPhoto,
                createdTime = 1L
            )
        }
        collectionDao.insertCollections(collections)
        return collections
    }

    override suspend fun getDataBaseListCollections(page: Int): List<Collection> =
     collectionDao.getCollections(10)

    override fun getPagingCollection() = unsplashApiService.getPagingCollection()
}
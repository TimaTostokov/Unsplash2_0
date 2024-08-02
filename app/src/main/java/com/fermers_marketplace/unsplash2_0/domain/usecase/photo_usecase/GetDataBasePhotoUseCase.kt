package com.fermers_marketplace.unsplash2_0.domain.usecase.photo_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.Photo
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoRepository
import com.fermers_marketplace.unsplash2_0.domain.usecase.photo_usecase.ListPhotoParam
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

/**
 * Получить список фотографий из БД
 */

class GetDataBasePhotoUseCase @Inject constructor(private val photoRepository: PhotoRepository) :
    UseCase<ListPhotoParam, List<Photo>>(Dispatchers.IO) {

    override suspend fun execute(param: ListPhotoParam): List<Photo> =
        photoRepository.getDataBaseListPhoto(param.page, param.orderBy.value)
}
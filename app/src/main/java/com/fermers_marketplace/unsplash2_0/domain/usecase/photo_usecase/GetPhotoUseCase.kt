package com.fermers_marketplace.unsplash2_0.domain.usecase.photo_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.Photo
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoRepository
import com.fermers_marketplace.unsplash2_0.ui.photo_screen.OrderListPhoto
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

data class ListPhotoParam(
    var page: Int,
    val orderBy: OrderListPhoto
)

/**
 * Получить список фотографий
 */
class GetPhotoUseCase @Inject constructor(private val photoRepository: PhotoRepository) :
    UseCase<ListPhotoParam, List<Photo>>(Dispatchers.IO) {
    override suspend fun execute(param: ListPhotoParam): List<Photo> =
        photoRepository.getListPhoto(param.page, param.orderBy.value)
}

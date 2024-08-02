package com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.Photo
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoDetailsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class
GetDataBasePhotoDetailsUseCase @Inject constructor(private val photoDetailsRepository: PhotoDetailsRepository) :
    UseCase<String, Photo>(Dispatchers.IO) {

    override suspend fun execute(param: String): Photo =
        photoDetailsRepository.getDataBasePhoto(param)
}
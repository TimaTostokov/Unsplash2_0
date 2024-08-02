package com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoDetails
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoDetailsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetPhotoDetailsUseCase @Inject constructor(private val photoDetailsRepository: PhotoDetailsRepository) :
    UseCase<String, PhotoDetails?>(Dispatchers.IO) {

    override suspend fun execute(photoId: String): PhotoDetails? =
        photoDetailsRepository.getPhotoDetail(photoId)
}
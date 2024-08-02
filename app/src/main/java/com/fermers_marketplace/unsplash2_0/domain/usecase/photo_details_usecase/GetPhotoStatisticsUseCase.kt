package com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoStatistics
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoDetailsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetPhotoStatisticsUseCase @Inject constructor(private val photoDetailsRepository: PhotoDetailsRepository) :
    UseCase<String, PhotoStatistics?>(Dispatchers.IO) {

    override suspend fun execute(photoId: String): PhotoStatistics? =
        photoDetailsRepository.getPhotoStatistics(photoId)
}
package com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoDetailsRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class PhotoDownloadUrl @Inject constructor(
    private val photoDetailsRepository: PhotoDetailsRepository,
) : UseCase<String, Unit>(Dispatchers.IO) {

    override suspend fun execute(param: String) {
        val photoDownloadUrls = photoDetailsRepository.getDownloadPhotoUrl(param)
        photoDownloadUrls.url?.let {
            photoDetailsRepository.downloadPhoto(param, it)
        }
    }
}
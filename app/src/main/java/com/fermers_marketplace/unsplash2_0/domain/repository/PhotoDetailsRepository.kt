package com.fermers_marketplace.unsplash2_0.domain.repository

import com.fermers_marketplace.unsplash2_0.domain.model.DownloadPhotoUrl
import com.fermers_marketplace.unsplash2_0.domain.model.Photo
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoDetails
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoStatistics

interface PhotoDetailsRepository {

    suspend fun getPhotoDetail(photoId: String): PhotoDetails?

    suspend fun getPhotoStatistics(photoId: String): PhotoStatistics?

    suspend fun getDownloadPhotoUrl(photoId: String): DownloadPhotoUrl

    suspend fun downloadPhoto(fileName: String, url: String): Long

    suspend fun getDataBasePhoto(userId: String): Photo
}
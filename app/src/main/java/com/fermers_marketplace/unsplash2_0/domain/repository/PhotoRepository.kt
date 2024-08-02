package com.fermers_marketplace.unsplash2_0.domain.repository

import com.fermers_marketplace.unsplash2_0.domain.model.Photo

interface PhotoRepository {
    suspend fun getListPhoto(page: Int, oderBy: String): List<Photo>

    suspend fun getDataBaseListPhoto(page: Int, oderBy: String): List<Photo>
}
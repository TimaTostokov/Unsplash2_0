package com.fermers_marketplace.unsplash2_0.domain.repository

import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.model.User
import com.fermers_marketplace.unsplash2_0.domain.model.dto.PhotoDto

interface SearchRepository {

    suspend fun getSearchPhotos(
        query: String,
        page: Int,
        perPage:Int,
        orderBy: String,
        contentFilter: String,
        color: String?,
        orientation: String?
    ): List<PhotoDto>

    suspend fun getSearchCollections(
        query: String,
        page: Int,
        perPage:Int,
    ): List<CollectionDto>

    suspend fun getSearchUsers(
        query: String,
        page: Int,
        perPage:Int,
    ): List<User>
}
package com.fermers_marketplace.unsplash2_0.data.repository

import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.model.User
import com.fermers_marketplace.unsplash2_0.domain.model.dto.PhotoDto
import com.fermers_marketplace.unsplash2_0.domain.repository.SearchRepository
import com.fermers_marketplace.unsplash2_0.services.apiservices.UnsplashApiService
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(val unsplashApiService: UnsplashApiService) :
    SearchRepository {

    override suspend fun getSearchPhotos(
        query: String,
        page: Int,
        perPage: Int,
        orderBy: String,
        contentFilter: String,
        color: String?,
        orientation: String?
    ): List<PhotoDto> =
        unsplashApiService.getSearchPhotos(
            query,
            page,
            10,
            orderBy,
            contentFilter,
            color.toString(),
            orientation.toString()
        ).results

    override suspend fun getSearchCollections(
        query: String,
        page: Int,
        perPage: Int,
        ): List<CollectionDto> =
        unsplashApiService.getSearchCollections(query, page, 10).results

    override suspend fun getSearchUsers(query: String, page: Int, perPage: Int): List<User> =
        unsplashApiService.getSearchUsers(query, page, 10).results
}
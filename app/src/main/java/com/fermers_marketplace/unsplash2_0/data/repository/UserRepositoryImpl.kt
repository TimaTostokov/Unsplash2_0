package com.fermers_marketplace.unsplash2_0.data.repository

import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.model.User
import com.fermers_marketplace.unsplash2_0.domain.model.UserPhoto
import com.fermers_marketplace.unsplash2_0.domain.repository.UserRepository
import com.fermers_marketplace.unsplash2_0.services.apiservices.UnsplashApiService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val unsplashApiService: UnsplashApiService,
) : UserRepository {

    /**
     * Получает список фото пользователя с сервера
     */
    override suspend fun getUserPhoto(userName: String, page: Int): List<UserPhoto> =
        unsplashApiService.getUsersPhoto(userName, page)

    /**
     * Получает список коллекций пользователя с сервера
     */
    override suspend fun getUserCollection(userName: String, page: Int): List<CollectionDto> =
        unsplashApiService.getUserCollection(userName, page)

    /**
     * Получает информацию пользователя с сервера
     */
    override suspend fun getUser(userName: String): User =
        unsplashApiService.getUser(userName)
}
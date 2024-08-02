package com.fermers_marketplace.unsplash2_0.domain.repository

import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.model.User
import com.fermers_marketplace.unsplash2_0.domain.model.UserPhoto

interface
UserRepository {

    suspend fun getUser(userName: String): User

    suspend fun getUserPhoto(userName: String, page: Int): List<UserPhoto>

    suspend fun getUserCollection(
        userName: String,
        page: Int
    ): List<CollectionDto>
}
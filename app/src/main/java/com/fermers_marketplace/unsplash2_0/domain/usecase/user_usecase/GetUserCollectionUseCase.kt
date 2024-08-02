package com.fermers_marketplace.unsplash2_0.domain.usecase.user_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.repository.UserRepository
import com.fermers_marketplace.unsplash2_0.domain.usecase.user_usecase.UserPhotoParam
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetUserCollectionUseCase @Inject constructor(private val userRepository: UserRepository) :
    UseCase<UserPhotoParam, List<CollectionDto>>(Dispatchers.IO) {

    override suspend fun execute(param: UserPhotoParam): List<CollectionDto> =
        userRepository.getUserCollection(param.userName, param.page)
}
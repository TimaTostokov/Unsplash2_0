package com.fermers_marketplace.unsplash2_0.domain.usecase.user_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.UserPhoto
import com.fermers_marketplace.unsplash2_0.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetUserPhotoUseCase @Inject constructor(private val userRepository: UserRepository) :
    UseCase<UserPhotoParam, List<UserPhoto>>(Dispatchers.IO) {

    override suspend fun execute(param: UserPhotoParam): List<UserPhoto> =
        userRepository.getUserPhoto(param.userName, param.page)
}

data class UserPhotoParam(
    val userName: String,
    val page: Int,
)
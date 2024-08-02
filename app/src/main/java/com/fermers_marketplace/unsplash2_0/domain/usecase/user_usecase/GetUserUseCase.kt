package com.fermers_marketplace.unsplash2_0.domain.usecase.user_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.User
import com.fermers_marketplace.unsplash2_0.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) :
    UseCase<String, User>(Dispatchers.IO) {

    override suspend fun execute(userName: String): User =
        userRepository.getUser(userName)
}
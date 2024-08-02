package com.fermers_marketplace.unsplash2_0.domain.usecase.login_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) :
    UseCase<String, String>(Dispatchers.IO) {
    override suspend fun execute(code: String): String =
        loginRepository.getAccessToken(code).accessToken
}
package com.fermers_marketplace.unsplash2_0.domain.usecase.login_usecase

import com.fermers_marketplace.unsplash2_0.UseCase
import com.fermers_marketplace.unsplash2_0.domain.model.Me
import com.fermers_marketplace.unsplash2_0.domain.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class GetMeUseCase @Inject constructor(private val loginRepository: LoginRepository) :
    UseCase.NoParam<Me>(Dispatchers.IO) {
    override suspend fun execute(): Me =
        loginRepository.getMe()
}
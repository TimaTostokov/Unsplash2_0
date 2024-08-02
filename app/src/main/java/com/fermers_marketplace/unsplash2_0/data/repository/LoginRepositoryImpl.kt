package com.fermers_marketplace.unsplash2_0.data.repository

import com.fermers_marketplace.unsplash2_0.constants.Const.GRANT_TYPE
import com.fermers_marketplace.unsplash2_0.constants.Const.REDIRECT_URI
import com.fermers_marketplace.unsplash2_0.domain.model.AccessToken
import com.fermers_marketplace.unsplash2_0.domain.model.Me
import com.fermers_marketplace.unsplash2_0.domain.repository.LoginRepository
import com.fermers_marketplace.unsplash2_0.services.apiservices.UnsplashApiService
import javax.inject.Inject

/**
 * Имплементация [LoginRepository]
 */
class LoginRepositoryImpl @Inject constructor(
    private val unsplashApiService: UnsplashApiService,
    private val accessTokenProvider: AccessTokenProvider,
) : LoginRepository {

    /**
     * Получает AccessToken при авторизпции
     *
     * @param code
     */
    override suspend fun getAccessToken(code: String): AccessToken =
        unsplashApiService.userAuthorization(
            accessTokenProvider.clientId.toString(),
            accessTokenProvider.clientSecret.toString(),
            REDIRECT_URI,
            code,
            GRANT_TYPE
        )

    /**
     * Получает данные пользователя (мой профиль)
     */
    override suspend fun getMe(): Me =
        unsplashApiService.getMe()

    /**
     * Проверяет наличие AccessToken
     */
    fun isAuthorized() = accessTokenProvider.isAuthorized

    /**
     * Получает имя пользователя
     */
    fun getUserName() = accessTokenProvider.userName

    /**
     * Получает почту пользователя
     */
    fun getEmail() = accessTokenProvider.email

    /**
     * Получает фото профиля пользователя
     */
    fun getProfileImage() = accessTokenProvider.profileImage

    fun logout() = accessTokenProvider.reset()
}
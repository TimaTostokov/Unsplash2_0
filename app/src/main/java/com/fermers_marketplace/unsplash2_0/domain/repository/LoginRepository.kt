package com.fermers_marketplace.unsplash2_0.domain.repository

import com.fermers_marketplace.unsplash2_0.domain.model.AccessToken
import com.fermers_marketplace.unsplash2_0.domain.model.Me

interface LoginRepository {

    suspend fun getAccessToken(code: String): AccessToken

    suspend fun getMe(): Me
}
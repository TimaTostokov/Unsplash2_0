package com.fermers_marketplace.unsplash2_0.domain.model

import com.fermers_marketplace.unsplash2_0.domain.model.dto.Urls
import com.google.gson.annotations.SerializedName

data class UserPhoto(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("user")
    val user: User,
    @SerializedName("urls")
    val url: Urls
)
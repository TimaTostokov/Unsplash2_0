package com.fermers_marketplace.unsplash2_0.domain.model.dto

import com.google.gson.annotations.SerializedName
import com.fermers_marketplace.unsplash2_0.domain.model.User

data class CollectionDto(
    val id: String = "",
    val title: String = "",
    val description: String = "",
    @SerializedName("total_photos")
    val totalPhoto: Int = 0,
    @SerializedName("cover_photo")
    val coverPhoto: CoverPhoto,
    val user: User,
    val private: Boolean
)

data class CoverPhoto(
    val id: String = "",
    val likes: Int? = 0,
    val description: String? = "",
    val user: User,
    @SerializedName("urls")
    val url: Urls?,
)
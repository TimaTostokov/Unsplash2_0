package com.fermers_marketplace.unsplash2_0.domain.model

import com.fermers_marketplace.unsplash2_0.domain.model.dto.CoverPhoto
import com.google.gson.annotations.SerializedName

data class CollectionDetails(
    val id: String,
    val title: String? = "",
    val description: String? = "",
    @SerializedName("total_photos")
    val totalPhotos: Int? = 0,
    @SerializedName("cover_photo")
    val coverPhoto: CoverPhoto,
    val user: User
)
package com.fermers_marketplace.unsplash2_0.domain.model

import com.google.gson.annotations.SerializedName
import com.fermers_marketplace.unsplash2_0.domain.model.dto.PhotoDto

data class SearchPhotos(
    val total: Int,
    @SerializedName("total_pages")
    val totalPages:Int,
    val results: List<PhotoDto>
)
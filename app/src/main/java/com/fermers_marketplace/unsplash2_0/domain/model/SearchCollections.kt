package com.fermers_marketplace.unsplash2_0.domain.model

import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.google.gson.annotations.SerializedName

data class
SearchCollections(
    val total: Int,
    @SerializedName("total_pages")
    val totalPages:Int,
    val results: List<CollectionDto>
)
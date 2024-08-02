package com.fermers_marketplace.unsplash2_0.domain.model

import com.google.gson.annotations.SerializedName

data class SearchUsers(
    val total: Int,
    @SerializedName("total_pages")
    val totalPages:Int,
    val results: List<User>
)
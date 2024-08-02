package com.fermers_marketplace.unsplash2_0.domain.model

import com.fermers_marketplace.unsplash2_0.domain.model.dto.Urls

data class CollectionPhotos(
    val id: String,
    val user: User,
    val urls: Urls
)
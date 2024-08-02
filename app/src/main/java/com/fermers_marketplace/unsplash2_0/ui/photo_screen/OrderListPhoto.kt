package com.fermers_marketplace.unsplash2_0.ui.photo_screen

import com.fermers_marketplace.unsplash2_0.R

enum class OrderListPhoto(val titleRes: Int, val value: String) {
    LATEST(R.string.order_by_latest_text, "latest"),
    OLDEST(R.string.order_by_oldest_text, "oldest"),
    POPULAR(R.string.order_by_popular_text, "popular")
}
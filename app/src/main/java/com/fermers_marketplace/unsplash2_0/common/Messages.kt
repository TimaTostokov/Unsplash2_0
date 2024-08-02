package com.fermers_marketplace.unsplash2_0.common

sealed interface Messages {
    object NetworkIsDisconnected : Messages
    object NetworkIsConnected : Messages
    object AlreadyDownloaded : Messages
    object ShowShimmer : Messages
    object HideShimmer : Messages
}
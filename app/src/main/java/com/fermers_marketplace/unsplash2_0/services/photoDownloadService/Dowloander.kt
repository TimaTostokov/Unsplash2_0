package com.fermers_marketplace.unsplash2_0.services.photoDownloadService

interface PhotoDownloader {
    fun downloadFile(fileName: String, url: String): Long
}
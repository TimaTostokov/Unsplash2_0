package com.fermers_marketplace.unsplash2_0.ui.photo_screen.photo_details_screen

import androidx.lifecycle.viewModelScope
import com.fermers_marketplace.unsplash2_0.common.Messages
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoDetails
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoStatistics
import com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase.GetDataBasePhotoDetailsUseCase
import com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase.GetPhotoDetailsUseCase
import com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase.GetPhotoStatisticsUseCase
import com.fermers_marketplace.unsplash2_0.domain.usecase.photo_details_usecase.PhotoDownloadUrl
import com.fermers_marketplace.unsplash2_0.ui.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhotoDetailsViewModel @Inject constructor(
    private val getPhotoDetails: GetPhotoDetailsUseCase,
    private val getPhotoStatistics: GetPhotoStatisticsUseCase,
    private val photoDownloadUrl: PhotoDownloadUrl,
    private val getDataBasePhotoDetailsUseCase: GetDataBasePhotoDetailsUseCase
) : BaseViewModel() {

    private val _photoDetails: MutableStateFlow<PhotoDetails?> = MutableStateFlow(null)
    val photoDetails: Flow<PhotoDetails> = _photoDetails.filterNotNull()

    private val _photoStatistics: MutableStateFlow<PhotoStatistics?> = MutableStateFlow(null)
    val photoStatistics: Flow<PhotoStatistics> = _photoStatistics.filterNotNull()

    private val _messageFlow = MutableStateFlow<Messages?>(null)
    val messageFlow: Flow<Messages> = _messageFlow.filterNotNull()

    private lateinit var photoId: String

    /**
     * Вызывается на onViewCreated у PhotoDetailsFragment
     */
    override fun onViewCreated() {
        loadDetailsPhoto(photoId)
        loadStatisticsPhoto(photoId)
    }

    /**
     * Получение информаании о фото
     */
    private fun loadDetailsPhoto(photoId: String) {
        viewModelScope.launch {
            getPhotoDetails.invoke(photoId)
                .onSuccess {
                    _photoDetails.value = it
                    _messageFlow.value = Messages.HideShimmer
                }.onFailure {
                    delay(1000)
                    getDataBasePhotoDetailsUseCase.invoke(photoId)
                    _messageFlow.value = Messages.HideShimmer
                }
        }
    }

    /**
     * Получение статистики фото
     */
    private fun loadStatisticsPhoto(photoId: String) {
        viewModelScope.launch {
            getPhotoStatistics.invoke(photoId)
                .onSuccess {
                    _photoStatistics.value = it
                    _messageFlow.value = Messages.HideShimmer
                }.onFailure {
                    delay(1000)
                    _messageFlow.value = Messages.NetworkIsDisconnected
                }
        }
    }

    fun setPhotoId(photoId: String) {
        this.photoId = photoId
    }

    /**
     * Загрузка фото на устройство
     */
    fun onDownloadClick(photoId: String) {
        viewModelScope.launch {
            photoDownloadUrl(photoId)
        }
    }

    fun clearMessage() {
        _messageFlow.value = null
    }
}
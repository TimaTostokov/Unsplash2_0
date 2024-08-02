package com.fermers_marketplace.unsplash2_0.ui.login_screen

import androidx.lifecycle.viewModelScope
import com.fermers_marketplace.unsplash2_0.Event
import com.fermers_marketplace.unsplash2_0.data.repository.AccessTokenProvider
import com.fermers_marketplace.unsplash2_0.domain.usecase.login_usecase.GetMeUseCase
import com.fermers_marketplace.unsplash2_0.domain.usecase.login_usecase.LoginUseCase
import com.fermers_marketplace.unsplash2_0.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getMeUseCase: GetMeUseCase,
    private val accessTokenProvider: AccessTokenProvider
) : BaseViewModel() {

    private val _token = MutableStateFlow<Event<String>>(Event.loading())
    val token: StateFlow<Event<String>> = _token.asStateFlow()

    fun login(code: String) {
        viewModelScope.launch {
            loginUseCase.invoke(code)
                .onSuccess {
                    _token.value = Event.success(it)
                    getMeUseCase.execute()
                }.onFailure {
                    _token.value = Event.error()
                }
        }
    }

    fun saveToken(token: String) {
        accessTokenProvider.accessToken = token
    }
}
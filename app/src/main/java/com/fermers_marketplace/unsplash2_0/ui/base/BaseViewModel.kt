package com.fermers_marketplace.unsplash2_0.ui.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    open fun onViewCreated() {}
}
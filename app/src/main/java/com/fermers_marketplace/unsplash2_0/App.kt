package com.fermers_marketplace.unsplash2_0

import android.app.Application
import com.fermers_marketplace.unsplash2_0.di.AppComponent
import com.fermers_marketplace.unsplash2_0.di.DbModule
import com.fermers_marketplace.unsplash2_0.di.NetworkModule
import com.fermers_marketplace.unsplash2_0.di.RepositoryModule

lateinit var appComponent: AppComponent
    private set

class App : Application() {

}
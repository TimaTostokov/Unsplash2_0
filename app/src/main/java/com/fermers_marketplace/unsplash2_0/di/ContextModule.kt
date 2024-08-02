package com.fermers_marketplace.unsplash2_0.di

import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ContextModule {

    @Singleton
    @Binds
    abstract fun context(appInstance: Context): Context
}
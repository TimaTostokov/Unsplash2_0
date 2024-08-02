package com.fermers_marketplace.unsplash2_0.di

import android.content.Context
import com.fermers_marketplace.unsplash2_0.ui.collection_screens.CollectionFragment
import com.fermers_marketplace.unsplash2_0.ui.collection_screens.collection_details.CollectionDetailsFragment
import com.fermers_marketplace.unsplash2_0.ui.login_screen.LoginFragment
import com.fermers_marketplace.unsplash2_0.ui.photo_screen.PhotoFragment
import com.fermers_marketplace.unsplash2_0.ui.photo_screen.photo_details_screen.PhotoDetailsFragment
import com.fermers_marketplace.unsplash2_0.ui.search_screen.SearchFragment
import com.fermers_marketplace.unsplash2_0.ui.search_screen.search_collection.SearchCollectionFragment
import com.fermers_marketplace.unsplash2_0.ui.search_screen.search_photo.SearchPhotoFragment
import com.fermers_marketplace.unsplash2_0.ui.search_screen.search_user.SearchUserFragment
import com.fermers_marketplace.unsplash2_0.user_screen.UserFragment
import com.fermers_marketplace.unsplash2_0.user_screen.user_collection.UserCollectionFragment
import com.fermers_marketplace.unsplash2_0.user_screen.users_photo.UserPhotoFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class, DbModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context: Context): Builder

        @BindsInstance
        fun networkModule(apiModule: NetworkModule): Builder

        @BindsInstance
        fun dbModule(interfaceModule: DbModule): Builder

        @BindsInstance
        fun repositoryModule(interfaceModule: RepositoryModule): Builder

        fun build(): AppComponent
    }

    fun inject(fragment: PhotoFragment)
    fun inject(fragment: PhotoDetailsFragment)
    fun inject(fragment: UserFragment)
    fun inject(fragment: CollectionFragment)
    fun inject(fragment: UserPhotoFragment)
    fun inject(fragment: UserCollectionFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: CollectionDetailsFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: SearchPhotoFragment)
    fun inject(fragment: SearchCollectionFragment)
    fun inject(fragment: SearchUserFragment)
}
package com.fermers_marketplace.unsplash2_0.di

import com.fermers_marketplace.unsplash2_0.data.repository.CollectionDetailsRepositoryImpl
import com.fermers_marketplace.unsplash2_0.data.repository.CollectionRepositoryImpl
import com.fermers_marketplace.unsplash2_0.data.repository.LoginRepositoryImpl
import com.fermers_marketplace.unsplash2_0.data.repository.PhotoDetailsRepositoryImpl
import com.fermers_marketplace.unsplash2_0.data.repository.PhotoRepositoryImpl
import com.fermers_marketplace.unsplash2_0.data.repository.SearchRepositoryImpl
import com.fermers_marketplace.unsplash2_0.data.repository.UserRepositoryImpl
import com.fermers_marketplace.unsplash2_0.domain.repository.CollectionDetailsRepository
import com.fermers_marketplace.unsplash2_0.domain.repository.CollectionRepository
import com.fermers_marketplace.unsplash2_0.domain.repository.LoginRepository
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoDetailsRepository
import com.fermers_marketplace.unsplash2_0.domain.repository.PhotoRepository
import com.fermers_marketplace.unsplash2_0.domain.repository.SearchRepository
import com.fermers_marketplace.unsplash2_0.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    /**
     * photo
     */

    @Provides
    fun providesPhotoRepository(photoRepository: PhotoRepositoryImpl): PhotoRepository =
        photoRepository

    /**
     * photo_details
     */

    @Provides
    fun providesPhotoDetailsRepository(photoDetailsRepository: PhotoDetailsRepositoryImpl): PhotoDetailsRepository =
        photoDetailsRepository

    /**
     *user
     */

    @Provides
    fun provideUsersPhotoRepository(usersRepository: UserRepositoryImpl): UserRepository =
        usersRepository

    /**
     *collection
     */
    @Provides
    fun provideCollectionRepository(collectionRepository: CollectionRepositoryImpl): CollectionRepository =
        collectionRepository

    /**
     *collection_details
     */
    @Provides
    fun provideCollectionDetailsRepository(collectionDetailsRepository: CollectionDetailsRepositoryImpl): CollectionDetailsRepository =
        collectionDetailsRepository

    /**
     * login
     */

    @Provides
    fun provideLoginRepository(loginRepository: LoginRepositoryImpl): LoginRepository =
        loginRepository

    /**
     * search
     */

    @Provides
    fun provideSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository =
        searchRepository
}
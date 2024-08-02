package com.fermers_marketplace.unsplash2_0.di

import android.content.Context
import androidx.room.Room
import com.fermers_marketplace.unsplash2_0.db.CollectionDao
import com.fermers_marketplace.unsplash2_0.db.CollectionDataBase
import com.fermers_marketplace.unsplash2_0.db.PhotoDao
import com.fermers_marketplace.unsplash2_0.db.PhotoDataBase
import com.fermers_marketplace.unsplash2_0.domain.model.Collection
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    fun providePhotoDataBase(context: Context): PhotoDataBase = PhotoDataBase(context)

    @Provides
    fun providePhotoDao(dataBase: PhotoDataBase): PhotoDao =
        dataBase.photoDao()

    @Provides
    fun provideCollectionDataBase(context: Context): CollectionDataBase = Room.databaseBuilder(
        context,
        CollectionDataBase::class.java,
        Collection.TABLE_NAME
    )
        .build()

    @Provides
    fun provideCollectionDao(dataBase: CollectionDataBase): CollectionDao =
        dataBase.collectionDao()
}
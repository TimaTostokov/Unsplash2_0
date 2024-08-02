package com.fermers_marketplace.unsplash2_0.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fermers_marketplace.unsplash2_0.domain.model.Collection

/**
 * БД для хранения списка фото
 */
@Database(entities = [Collection::class], version = 1)

abstract class CollectionDataBase : RoomDatabase() {
    abstract fun collectionDao(): CollectionDao
}
package com.fermers_marketplace.unsplash2_0.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.fermers_marketplace.unsplash2_0.domain.model.Photo

/**
 * Интерфейс с запросами с БД
 */
@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photos: List<Photo>)

    @Query("SELECT * FROM ${Photo.TABLE_NAME} order by createdTime desc limit :count")
    suspend fun getPhotos(count: Int): List<Photo>

    @Query("SELECT * FROM ${Photo.TABLE_NAME} WHERE id =:photoId")
    suspend fun getPhoto(photoId: String): Photo
}

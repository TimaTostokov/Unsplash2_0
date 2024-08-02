package com.fermers_marketplace.unsplash2_0.services.apiservices

import com.fermers_marketplace.unsplash2_0.constants.Const.GRANT_TYPE
import com.fermers_marketplace.unsplash2_0.constants.Const.PER_PAGE
import com.fermers_marketplace.unsplash2_0.constants.Const.REDIRECT_URI
import com.fermers_marketplace.unsplash2_0.constants.Const.YOUR_ACCESS_KEY
import com.fermers_marketplace.unsplash2_0.constants.Const.YOUR_SECRET_KEY
import com.fermers_marketplace.unsplash2_0.domain.model.AccessToken
import com.fermers_marketplace.unsplash2_0.domain.model.CollectionDetails
import com.fermers_marketplace.unsplash2_0.domain.model.CollectionPhotos
import com.fermers_marketplace.unsplash2_0.domain.model.DownloadPhotoUrl
import com.fermers_marketplace.unsplash2_0.domain.model.Me
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoDetails
import com.fermers_marketplace.unsplash2_0.domain.model.PhotoStatistics
import com.fermers_marketplace.unsplash2_0.domain.model.SearchCollections
import com.fermers_marketplace.unsplash2_0.domain.model.SearchPhotos
import com.fermers_marketplace.unsplash2_0.domain.model.SearchUsers
import com.fermers_marketplace.unsplash2_0.domain.model.User
import com.fermers_marketplace.unsplash2_0.domain.model.UserPhoto
import com.fermers_marketplace.unsplash2_0.domain.model.dto.CollectionDto
import com.fermers_marketplace.unsplash2_0.domain.model.dto.PhotoDto
import com.fermers_marketplace.unsplash2_0.ui.search_screen.search_photo.ColorSearchPhoto
import com.fermers_marketplace.unsplash2_0.ui.search_screen.search_photo.ContentFilterSearchPhoto
import com.fermers_marketplace.unsplash2_0.ui.search_screen.search_photo.OrderSearchPhoto
import com.fermers_marketplace.unsplash2_0.ui.search_screen.search_photo.OrientationSearchPhoto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashApi {

    /**
     * photos
     */
    @GET("photos")
    @Headers(
        "Accept-Version: v1",
    )
    suspend fun getPhotos(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int? = PER_PAGE,
        @Query("order_by") orderBy: String,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): List<PhotoDto>

    /**
     *photo_details
     */
    @GET("photos/{id}")
    suspend fun getPhotoDetails(
        @Path("id")
        photoId: String,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): PhotoDetails?

    @GET("photos/{id}/statistics")
    suspend fun getPhotoStatistics(
        @Path("id")
        photoId: String,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): PhotoStatistics?

    @GET("photos/{id}/download")
    suspend fun getDownloadPhotoUri(
        @Path("id")
        photoId: String,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): DownloadPhotoUrl?

    /**
     *collection
     */
    @GET("collections")
    suspend fun getCollections(
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int? = PER_PAGE,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): List<CollectionDto>

    /**
     *collection_details
     */
    @GET("collections/{id}")
    suspend fun getCollectionsDetails(
        @Path("id")
        collectionId: String,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): CollectionDetails

    @GET("collections/{id}/photos")
    suspend fun getCollectionPhotos(
        @Path("id")
        collectionId: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int? = PER_PAGE,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): List<CollectionPhotos>

    /**
     *user
     */
    @GET("users/{username}")
    suspend fun getUser(
        @Path("username")
        userName: String,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): User

    @GET("users/{username}/photos")
    suspend fun getUsersPhoto(
        @Path("username")
        userName: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int? = PER_PAGE,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): List<UserPhoto>

    @GET("users/{username}/collections")
    suspend fun getUserCollections(
        @Path("username")
        userName: String,
        @Query("page") page: Int?,
        @Query("per_page") perPage: Int? = PER_PAGE,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): List<CollectionDto>

    @GET("me")
    suspend fun getMe(): Me

    @POST("oauth/token")
    suspend fun userAuthorization(
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY,
        @Query("client_secret") clientSecret: String = YOUR_SECRET_KEY,
        @Query("redirect_uri") redirectUri: String = REDIRECT_URI,
        @Query("code") code: String,
        @Query("grant_type") grantType: String = GRANT_TYPE
    ): AccessToken

    /**
     *search
     */
    @GET("search/photos")
    suspend fun getSearchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PER_PAGE,
        @Query("order_by") orderBy: String = OrderSearchPhoto.LATEST.value,
        @Query("content_filter") contentFilter: String = ContentFilterSearchPhoto.LOW.value,
        @Query("color") color: String? = ColorSearchPhoto.ANY.value.orEmpty(),
        @Query("orientation") orientation: String? = OrientationSearchPhoto.ANY.value.orEmpty(),
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): SearchPhotos

    @GET("search/collections")
    suspend fun getSearchCollections(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PER_PAGE,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): SearchCollections

    @GET("search/users")
    suspend fun getSearchUsers(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = PER_PAGE,
        @Query("client_id") clientId: String = YOUR_ACCESS_KEY
    ): SearchUsers
}
package com.android.anonymous_02_22.data.remote

import com.android.anonymous_02_22.data.remote.respond.ModelFollow
import com.android.anonymous_02_22.data.remote.respond.ModelSearch
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiServices {

    @GET("users/{username}")
    suspend fun detailUser(@Path("username") username: String?): ModelUser

    @GET("/search/users")
    suspend fun searchUser(

        @Query("q") username: String?
    ): ModelSearch?

    @GET("users/{username}/followers")
    suspend fun followersUser(
        @Path("username") username: String?
    ): List<ModelFollow?>?

    @GET("users/{username}/following")
    suspend fun followingUser(
        @Path("username") username: String?
    ): List<ModelFollow?>?

}
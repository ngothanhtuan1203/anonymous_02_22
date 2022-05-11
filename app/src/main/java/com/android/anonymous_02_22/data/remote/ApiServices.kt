package com.android.anonymous_02_22.data.remote

import com.android.anonymous_02_22.data.remote.respond.CoinRespond
import com.android.anonymous_02_22.data.remote.respond.ModelSearch
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import com.android.anonymous_02_22.data.remote.respond.country.CountryCarInfoRespond
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url


interface ApiServices {

    @GET("users/{username}")
    suspend fun detailUser(@Path("username") username: String?): ModelUser

    @GET("/search/users")
    suspend fun searchUser(

        @Query("q") username: String?
    ): ModelSearch?

    @GET
    suspend fun getCountryCarInfo(@Url fullUrl:String): CountryCarInfoRespond?

    @GET
    suspend fun getCoinInformation(@Url fullUrl:String): CoinRespond?

}
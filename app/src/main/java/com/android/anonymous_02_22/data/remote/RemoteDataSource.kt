package com.android.anonymous_02_22.data.remote


import com.android.anonymous_02_22.data.remote.respond.CoinRespond
import com.android.anonymous_02_22.data.remote.respond.ModelSearch
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import com.android.anonymous_02_22.data.remote.respond.country.CountryCarInfoRespond

interface RemoteDataSource {
    suspend fun  detailUser(username: String?): ModelUser

    suspend fun searchUser( username: String?): ModelSearch?
    suspend fun getCountryCarInfo( url: String): CountryCarInfoRespond?

    suspend fun fetchCoinInfo( url: String): CoinRespond?
}
package com.android.anonymous_02_22.data.remote

import com.android.anonymous_02_22.data.remote.respond.CoinRespond
import com.android.anonymous_02_22.data.remote.respond.ModelSearch
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import com.android.anonymous_02_22.data.remote.respond.country.CountryCarInfoRespond
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiServices
) : RemoteDataSource {
    override suspend fun detailUser(username: String?): ModelUser {
       return apiService.detailUser(username)
    }

    override suspend fun searchUser(username: String?): ModelSearch? {
        return apiService.searchUser(username)
    }

    override suspend fun getCountryCarInfo(url:String): CountryCarInfoRespond? {
        return apiService.getCountryCarInfo(url)
    }

    override suspend fun fetchCoinInfo(url: String): CoinRespond? {
        return apiService.getCoinInformation(url)
    }
}
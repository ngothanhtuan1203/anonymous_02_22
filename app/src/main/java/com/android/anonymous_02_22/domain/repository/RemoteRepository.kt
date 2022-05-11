package com.android.anonymous_02_22.domain.repository

import com.android.anonymous_02_22.data.remote.RemoteDataSource
import com.android.anonymous_02_22.data.remote.respond.CoinRespond
import com.android.anonymous_02_22.data.remote.respond.ModelSearchData
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import com.android.anonymous_02_22.data.remote.respond.country.CountryCarInfoRespond
import com.android.anonymous_02_22.domain.entities.CoinInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun searchUsers(keyWord:String): List<ModelSearchData> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.searchUser(keyWord)?.modelSearchData ?: emptyList<ModelSearchData>()
        }
    }


    suspend fun fetchUserDetail(userName:String): ModelUser {
        return withContext(Dispatchers.IO) {
            remoteDataSource.detailUser(userName)
        }
    }

    suspend fun fetchCountryCarInfo(url:String): CountryCarInfoRespond? {
        return withContext(Dispatchers.IO) {
            remoteDataSource.getCountryCarInfo(url)
        }
    }

    suspend fun fetchCoinInfo(url:String): CoinRespond? {
        return withContext(Dispatchers.IO) {
            remoteDataSource.fetchCoinInfo(url)
        }
    }
}
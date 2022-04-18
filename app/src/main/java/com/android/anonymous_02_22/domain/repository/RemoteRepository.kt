package com.android.anonymous_02_22.domain.repository

import com.android.anonymous_02_22.data.local.LocalDataSource
import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.remote.RemoteDataSource
import com.android.anonymous_02_22.data.remote.respond.ModelSearchData
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import com.android.anonymous_02_22.domain.entities.GitProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun searchUsers(keyWord:String): List<ModelSearchData> {
        return withContext(Dispatchers.IO) {
            remoteDataSource.searchUser(keyWord)?.modelSearchData ?: emptyList<ModelSearchData>()
        }
    }
}
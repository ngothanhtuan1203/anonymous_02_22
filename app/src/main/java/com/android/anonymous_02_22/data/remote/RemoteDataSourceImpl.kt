package com.android.anonymous_02_22.data.remote

import com.android.anonymous_02_22.data.remote.respond.ModelFollow
import com.android.anonymous_02_22.data.remote.respond.ModelSearch
import com.android.anonymous_02_22.data.remote.respond.ModelUser
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

    override suspend fun followersUser(username: String?): List<ModelFollow?>? {
        return apiService.followersUser(username)
    }

    override suspend fun followingUser(username: String?): List<ModelFollow?>? {
        return apiService.followingUser(username)
    }
}
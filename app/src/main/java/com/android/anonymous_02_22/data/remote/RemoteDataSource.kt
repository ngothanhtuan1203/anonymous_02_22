package com.android.anonymous_02_22.data.remote

import com.android.anonymous_02_22.data.remote.respond.ModelFollow
import com.android.anonymous_02_22.data.remote.respond.ModelSearch
import com.android.anonymous_02_22.data.remote.respond.ModelUser

interface RemoteDataSource {
    suspend fun  detailUser(username: String?): ModelUser

    suspend fun searchUser( username: String?): ModelSearch?

    suspend fun followersUser(username: String?): List<ModelFollow?>?

    suspend fun followingUser(username: String?): List<ModelFollow?>?
}
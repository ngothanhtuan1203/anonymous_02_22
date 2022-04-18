package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.FoundUser

interface GitAppUseCase :BaseUseCase{
    suspend fun searchUsers(keyword:String): List<FoundUser>
}
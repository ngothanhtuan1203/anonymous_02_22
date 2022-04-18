package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.GitProfile

interface DetailUserUseCase :BaseUseCase{

    suspend fun fetchUserDetail(userName:String): GitProfile
}
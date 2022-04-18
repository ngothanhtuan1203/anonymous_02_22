package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.CryptoInfo

interface CryptoInfoUseCase:BaseUseCase {
    suspend fun initMockData()
    suspend fun fetchAll(): List<CryptoInfo>
}
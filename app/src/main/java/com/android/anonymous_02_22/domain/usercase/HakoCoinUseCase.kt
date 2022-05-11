package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.CoinInfo
import com.android.anonymous_02_22.domain.entities.FoundUser

interface HakoCoinUseCase :BaseUseCase{
    suspend fun fetchCoins(): List<CoinInfo>
}
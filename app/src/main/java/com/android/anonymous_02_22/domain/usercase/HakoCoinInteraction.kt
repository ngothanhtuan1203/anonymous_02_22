package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.CoinInfo
import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.domain.entities.GitProfile
import com.android.anonymous_02_22.domain.mapper.CoinSearchModelMapper
import com.android.anonymous_02_22.domain.mapper.GitSearchModelMapper
import com.android.anonymous_02_22.domain.repository.RemoteRepository
import com.android.anonymous_02_22.utility.Constant
import javax.inject.Inject

class HakoCoinInteraction @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val mapper: CoinSearchModelMapper
) : HakoCoinUseCase {
    override suspend fun fetchCoins(): List<CoinInfo> {
        val initList = remoteRepository.fetchCoinInfo(Constant.COIN_INFO_MOCK_API)
        return mapper.toDomainList(initList?.data?: emptyList())
    }
}
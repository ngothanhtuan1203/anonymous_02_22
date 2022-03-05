package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.CryptoInfo
import com.android.anonymous_02_22.domain.mapper.CryptoInfoMapper
import com.android.anonymous_02_22.domain.repository.LocalRepository
import javax.inject.Inject

class CryptoInfoInteraction @Inject constructor(
    private val localRepository: LocalRepository,
    private val mapper: CryptoInfoMapper
) : CryptoInfoUseCase {
    override suspend fun initMockData() {
        val testData = localRepository.fetchAllTestData()

        testData.forEach {
            localRepository.insertCryptic(it.name, it.symbol,it.id)
        }
    }


    override suspend fun fetchAll(): List<CryptoInfo> {
        val cyptics = localRepository.fetchAll()
        var result = emptyList<CryptoInfo>()
        result = mapper.toDomainList(cyptics)
        return result
    }
}
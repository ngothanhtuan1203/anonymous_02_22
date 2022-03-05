package com.android.anonymous_02_22.domain.mapper

import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.local.database.entities.MockCryptic
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import javax.inject.Inject

class CryptoInfoMapper @Inject constructor() : DomainMapper<Cryptic, CryptoInfo> {

    override fun mapToDomainModel(model: Cryptic): CryptoInfo {
        return CryptoInfo(id = model.euid,
                name = model.name,
                symbol = model.symbol
        )
    }


    fun toDomainList(initial: List<Cryptic>): List<CryptoInfo>{
        return initial.map { mapToDomainModel(it) }
    }

}
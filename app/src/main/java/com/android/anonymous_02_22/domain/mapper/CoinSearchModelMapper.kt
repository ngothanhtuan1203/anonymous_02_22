package com.android.anonymous_02_22.domain.mapper

import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.local.database.entities.MockCryptic
import com.android.anonymous_02_22.data.remote.respond.Coin
import com.android.anonymous_02_22.data.remote.respond.ModelSearchData
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import com.android.anonymous_02_22.domain.entities.CoinInfo
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.domain.entities.GitProfile
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class CoinSearchModelMapper @Inject constructor() : DomainMapper<Coin, CoinInfo> {

    fun toDomainList(initial: List<Coin>): List<CoinInfo>{
        return initial.map { mapToDomainModel(it) }
    }

    override fun mapToDomainModel(model: Coin): CoinInfo {
        return CoinInfo(
            base = model.base,
            counter = model.counter,
            buyPrice = model.buyPrice,
            sellPrice = model.sellPrice,
            icon = model.icon,
            name = model.name
        )
    }

}
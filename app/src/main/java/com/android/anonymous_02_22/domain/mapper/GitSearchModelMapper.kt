package com.android.anonymous_02_22.domain.mapper

import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.local.database.entities.MockCryptic
import com.android.anonymous_02_22.data.remote.respond.ModelSearchData
import com.android.anonymous_02_22.data.remote.respond.ModelUser
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import com.android.anonymous_02_22.domain.entities.FoundUser
import com.android.anonymous_02_22.domain.entities.GitProfile
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class GitSearchModelMapper @Inject constructor() : DomainMapper<ModelSearchData, FoundUser> {

    fun toDomainList(initial: List<ModelSearchData>): List<FoundUser>{
        return initial.map { mapToDomainModel(it) }
    }

    override fun mapToDomainModel(model: ModelSearchData): FoundUser {
        return FoundUser(
            login = model.login,
            avatarUrl = model.avatarUrl,
            url = model.url,
            htmlUrl = model.htmlUrl
        )
    }

}
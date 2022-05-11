package com.android.anonymous_02_22.domain.mapper

import com.android.anonymous_02_22.data.local.database.entities.Country
import com.android.anonymous_02_22.domain.entities.CountryInfo
import javax.inject.Inject

class CountryInfoMapper @Inject constructor() : DomainMapper<Country, CountryInfo> {

    override fun mapToDomainModel(model: Country): CountryInfo {
        return CountryInfo(id = model.id,
                name = model.name,
                symbol = model.symbol
        )
    }


    fun toDomainList(initial: List<Country>): List<CountryInfo>{
        return initial.map { mapToDomainModel(it) }
    }

}
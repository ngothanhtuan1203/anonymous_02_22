package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.data.local.database.entities.Country
import com.android.anonymous_02_22.domain.entities.CarInfo
import com.android.anonymous_02_22.domain.entities.CountryInfo

interface CountryUseCase :BaseUseCase{
    suspend fun fetchCountries(): List<CountryInfo>
    suspend fun fetchCarInfo(countryCode:String): CarInfo
}
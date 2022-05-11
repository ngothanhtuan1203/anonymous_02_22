package com.android.anonymous_02_22.domain.usercase

import com.android.anonymous_02_22.domain.entities.CarInfo
import com.android.anonymous_02_22.domain.entities.CountryInfo
import com.android.anonymous_02_22.domain.entities.GitProfile
import com.android.anonymous_02_22.domain.mapper.CountryInfoMapper
import com.android.anonymous_02_22.domain.mapper.GitProfileMapper
import com.android.anonymous_02_22.domain.repository.LocalRepository
import com.android.anonymous_02_22.domain.repository.RemoteRepository
import com.android.anonymous_02_22.utility.Constant
import javax.inject.Inject

class CountryInteraction @Inject constructor(
    private val remoteRepository: RemoteRepository,
    private val localRepository: LocalRepository,
    private val mapper: CountryInfoMapper
) : CountryUseCase {
    override suspend fun fetchCountries(): List<CountryInfo> {
        val model = localRepository.fetchCountries()
        return mapper.toDomainList(model)
    }

    override suspend fun fetchCarInfo(countryCode: String): CarInfo {
       val data = remoteRepository.fetchCountryCarInfo(Constant.CAR_INFO_MOCK_API)
       return CarInfo("","","")
    }

}
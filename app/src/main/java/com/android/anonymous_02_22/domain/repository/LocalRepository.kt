package com.android.anonymous_02_22.domain.repository

import com.android.anonymous_02_22.data.local.LocalDataSource
import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.local.database.entities.Country
import com.android.anonymous_02_22.domain.entities.CryptoInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalRepository @Inject constructor(private val localDataSource: LocalDataSource) {
    suspend fun insertCryptic(name: String, symbols: String, euid: String) {
        localDataSource.insertCryptic(name, symbols, euid)
    }

    suspend fun fetchAll(): List<Cryptic> {
        return withContext(Dispatchers.IO) { localDataSource.fetchCrypts() }
    }

    suspend fun fetchAllTestData(): List<CryptoInfo> {
        val initList = localDataSource.fetchCryptsFromAsset()

        return initList.map {
            CryptoInfo(
                id = it.id,
                name = it.name,
                symbol = it.symbol
            )
        }

    }

    suspend fun fetchCountries(): List<Country> {
        val initList = localDataSource.fetchCountriesFromAsset()

        return initList

    }
}
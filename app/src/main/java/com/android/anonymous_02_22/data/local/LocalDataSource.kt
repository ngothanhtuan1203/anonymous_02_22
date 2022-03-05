package com.android.anonymous_02_22.data.local

import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.local.database.entities.MockCryptic
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertCryptic(name: String, symbol: String,euid:String)
    suspend fun fetchCrypts(): List<Cryptic>

    suspend fun fetchCryptsFromAsset(): List<MockCryptic>
}
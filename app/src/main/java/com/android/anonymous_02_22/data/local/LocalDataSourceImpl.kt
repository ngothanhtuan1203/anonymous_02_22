package com.android.anonymous_02_22.data.local

import com.android.anonymous_02_22.data.local.database.dao.CrypticDao
import com.android.anonymous_02_22.data.local.database.entities.Cryptic
import com.android.anonymous_02_22.data.local.database.entities.Country
import com.android.anonymous_02_22.data.local.database.entities.MockCryptic
import com.android.anonymous_02_22.utility.JsonUtil
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.reflect.Type
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val crypticDao: CrypticDao,private val appPrefs: AppPrefs) : LocalDataSource {

    override suspend fun insertCryptic(name: String, symbols: String,euid:String) {
        val cryptic = Cryptic(name, symbols,euid)
        return  crypticDao.insertCryptic(cryptic)
    }

    override suspend fun fetchCrypts(): List<Cryptic> {
       return crypticDao.getAll()
    }

    override suspend fun fetchCryptsFromAsset(): List<MockCryptic> {

        return withContext(Dispatchers.IO) {
            try {
                val bufferReader = appPrefs.getData()
                val groupListType: Type = object : TypeToken<List<MockCryptic?>?>() {}.type
                val cryptoInfos = JsonUtil.fromJsonToList<MockCryptic>(bufferReader, groupListType)
                cryptoInfos ?: emptyList()
            } catch (e:Exception) {
                e.printStackTrace()
                emptyList()
            }

        }
    }

    override suspend fun fetchCountriesFromAsset(): List<Country> {
        return withContext(Dispatchers.IO) {
            try {
                val bufferReader = appPrefs.getCountries()
                val groupListType: Type = object : TypeToken<List<Country?>?>() {}.type
                val cryptoInfos = JsonUtil.fromJsonToList<Country>(bufferReader, groupListType)
                cryptoInfos ?: emptyList()
            } catch (e:Exception) {
                e.printStackTrace()
                emptyList()
            }

        }
    }
}
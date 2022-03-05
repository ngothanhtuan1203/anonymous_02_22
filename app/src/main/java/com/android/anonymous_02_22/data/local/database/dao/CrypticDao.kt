package com.android.anonymous_02_22.data.local.database.dao

import androidx.room.*
import com.android.anonymous_02_22.data.local.database.entities.Cryptic

@Dao
interface CrypticDao {
    @Query("SELECT * FROM cryptic")
    suspend fun getAll(): List<Cryptic>

    @Query("SELECT * FROM cryptic where id =:crypticId")
    suspend fun getCrypticById(crypticId: Int): Cryptic

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCryptic(cryptic: Cryptic)

    @Delete
    suspend fun deleteCryptic(cryptic: Cryptic)
}
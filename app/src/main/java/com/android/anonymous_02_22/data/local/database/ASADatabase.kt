package org.anspace.mindfulness.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.anonymous_02_22.data.local.database.dao.CrypticDao
import com.android.anonymous_02_22.data.local.database.entities.Cryptic

@Database(entities = [Cryptic::class],  version = 10, exportSchema = false)
abstract class ASADatabase : RoomDatabase() {
    abstract fun crypticDao(): CrypticDao

    companion object {
        @Volatile
        private var instance: ASADatabase? = null
        private const val DB = "_asa_database"
        fun getDatabase(context: Context): ASADatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, ASADatabase::class.java, DB)
                .fallbackToDestructiveMigration()
                .build()
    }


}
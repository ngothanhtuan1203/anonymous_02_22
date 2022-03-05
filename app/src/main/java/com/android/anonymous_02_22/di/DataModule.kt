package com.android.anonymous_02_22.di

import android.content.Context
import android.content.res.Resources
import com.android.anonymous_02_22.data.local.AppPrefs
import com.android.anonymous_02_22.data.local.LocalDataSource
import com.android.anonymous_02_22.data.local.LocalDataSourceImpl
import com.android.anonymous_02_22.data.local.database.dao.CrypticDao
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.anspace.mindfulness.data.local.database.ASADatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {
    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources {
        return context.resources
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().setDateFormat("yyyy-MM-dd").create()
    }



    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context, gson: Gson): AppPrefs {
        return AppPrefs(gson, context)
    }


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ASADatabase {
        return ASADatabase.getDatabase(context)
    }

    @Provides
    fun provideUserDao(db: ASADatabase): CrypticDao {
        return db.crypticDao()
    }

    @Singleton
    @Provides
    fun provideLocalDataSource(localDataSource: LocalDataSourceImpl): LocalDataSource = localDataSource
}
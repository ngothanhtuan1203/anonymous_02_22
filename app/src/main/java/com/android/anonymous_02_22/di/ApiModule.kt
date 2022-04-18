package com.android.anonymous_02_22.di

import android.content.Context
import com.android.anonymous_02_22.data.local.AppPrefs
import com.android.anonymous_02_22.data.remote.ApiServices
import com.android.anonymous_02_22.data.remote.NetworkUtils
import com.android.anonymous_02_22.data.remote.RemoteDataSource
import com.android.anonymous_02_22.data.remote.RemoteDataSourceImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {

    @Provides
    @Singleton
    fun provideNetworkUtils(@ApplicationContext context: Context, gson: Gson, prefs: AppPrefs): NetworkUtils {
        return NetworkUtils(context, gson, prefs)
    }

    @Provides
    @Singleton
    fun provideRetrofit(utils: NetworkUtils): Retrofit {
        return utils.createRetrofit()
    }

    @Provides
    @Singleton
    fun provideRemoteDataSource(remoteDataSource: RemoteDataSourceImpl): RemoteDataSource =
        remoteDataSource

    @Provides
    @Singleton
    fun provideApiServices(utils: NetworkUtils, retrofit: Retrofit): ApiServices {
        return utils.createApiService(retrofit)
    }
}
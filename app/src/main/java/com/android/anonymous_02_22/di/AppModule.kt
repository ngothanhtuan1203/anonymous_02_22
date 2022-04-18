package com.android.anonymous_02_22.di

import android.content.Context
import android.content.res.Resources
import com.android.anonymous_02_22.domain.usercase.CryptoInfoInteraction
import com.android.anonymous_02_22.domain.usercase.CryptoInfoUseCase
import com.android.anonymous_02_22.domain.usercase.GitAppInteraction
import com.android.anonymous_02_22.domain.usercase.GitAppUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {




    @Provides
    @Singleton
    fun provideApplication(): BaseApplication =
        BaseApplication()

    @Provides
    @Singleton
    fun provideCryptoInteraction(cryptoInfoInteraction: CryptoInfoInteraction): CryptoInfoUseCase =
        cryptoInfoInteraction

    @Provides
    @Singleton
    fun provideGitAppInteraction(cryptoInfoInteraction: GitAppInteraction): GitAppUseCase =
        cryptoInfoInteraction

}
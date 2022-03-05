package com.android.anonymous_02_22.di

import com.android.anonymous_02_22.domain.usercase.CryptoInfoInteraction
import com.android.anonymous_02_22.domain.usercase.CryptoInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun provideInteraction(cryptoInfoInteraction: CryptoInfoInteraction): CryptoInfoUseCase =
        cryptoInfoInteraction

}
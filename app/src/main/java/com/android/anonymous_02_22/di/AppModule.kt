package com.android.anonymous_02_22.di

import com.android.anonymous_02_22.domain.usercase.*
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
    fun provideSearchUserInteraction(searchUserUseCase: SearchUserInteraction): SearchUserUseCase =
        searchUserUseCase

    @Provides
    @Singleton
    fun provideDetailUserInteraction(detailUserInteraction: DetailUserInteraction): DetailUserUseCase =
        detailUserInteraction


    @Provides
    @Singleton
    fun provideCountryInteraction(countryInteraction: CountryInteraction): CountryUseCase =
        countryInteraction

    @Provides
    @Singleton
    fun provideCoinInteraction(countryInteraction: HakoCoinInteraction): HakoCoinUseCase =
        countryInteraction

}
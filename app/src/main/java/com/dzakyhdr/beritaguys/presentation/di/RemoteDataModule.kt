package com.dzakyhdr.beritaguys.presentation.di

import com.dzakyhdr.beritaguys.data.api.NewsAPIService
import com.dzakyhdr.beritaguys.data.repository.datasource.NewsRemoteDataSource
import com.dzakyhdr.beritaguys.data.repository.datasourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(newsAPIService: NewsAPIService): NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}
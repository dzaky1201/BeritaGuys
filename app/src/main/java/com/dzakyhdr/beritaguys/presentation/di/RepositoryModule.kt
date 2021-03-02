package com.dzakyhdr.beritaguys.presentation.di

import com.dzakyhdr.beritaguys.data.repository.NewsRepositoryImpl
import com.dzakyhdr.beritaguys.data.repository.datasource.NewsRemoteDataSource
import com.dzakyhdr.beritaguys.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(newsRemoteDataSource: NewsRemoteDataSource): NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource)
    }
}
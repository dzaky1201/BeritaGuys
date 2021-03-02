package com.dzakyhdr.beritaguys.presentation.di

import com.dzakyhdr.beritaguys.domain.repository.NewsRepository
import com.dzakyhdr.beritaguys.domain.usecase.GetNewsHeadlineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsHeadlineUseCase(newsRepository: NewsRepository): GetNewsHeadlineUseCase {
        return GetNewsHeadlineUseCase(newsRepository)
    }
}
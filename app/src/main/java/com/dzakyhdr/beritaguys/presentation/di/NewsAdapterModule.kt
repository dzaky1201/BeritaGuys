package com.dzakyhdr.beritaguys.presentation.di

import com.dzakyhdr.beritaguys.presentation.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NewsAdapterModule {

    @Singleton
    @Provides
    fun provideNewsAdapter(): NewsAdapter{
        return NewsAdapter()
    }
}
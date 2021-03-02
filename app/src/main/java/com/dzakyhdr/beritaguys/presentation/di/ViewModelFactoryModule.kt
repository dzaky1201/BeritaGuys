package com.dzakyhdr.beritaguys.presentation.di

import android.app.Application
import com.dzakyhdr.beritaguys.domain.usecase.GetNewsHeadlineUseCase
import com.dzakyhdr.beritaguys.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class ViewModelFactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModel(
        app: Application,
        getNewsHeadlineUseCase: GetNewsHeadlineUseCase
    ): NewsViewModelFactory {
        return NewsViewModelFactory(app, getNewsHeadlineUseCase)
    }
}
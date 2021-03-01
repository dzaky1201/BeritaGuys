package com.dzakyhdr.beritaguys.domain.usecase

import com.dzakyhdr.beritaguys.data.model.Article
import com.dzakyhdr.beritaguys.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }
}
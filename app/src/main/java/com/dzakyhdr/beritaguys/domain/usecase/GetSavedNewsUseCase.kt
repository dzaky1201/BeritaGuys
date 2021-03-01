package com.dzakyhdr.beritaguys.domain.usecase

import com.dzakyhdr.beritaguys.data.model.Article
import com.dzakyhdr.beritaguys.domain.repository.NewsRepository

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.savedNews(article)
}
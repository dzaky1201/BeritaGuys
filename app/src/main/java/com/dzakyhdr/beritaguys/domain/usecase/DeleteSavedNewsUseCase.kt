package com.dzakyhdr.beritaguys.domain.usecase

import com.dzakyhdr.beritaguys.data.model.Article
import com.dzakyhdr.beritaguys.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}
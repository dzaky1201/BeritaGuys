package com.dzakyhdr.beritaguys.domain.usecase

import com.dzakyhdr.beritaguys.data.model.APIResponse
import com.dzakyhdr.beritaguys.data.util.Resource
import com.dzakyhdr.beritaguys.domain.repository.NewsRepository

class GetSearchNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return newsRepository.getSearchNews(searchQuery)
    }
}
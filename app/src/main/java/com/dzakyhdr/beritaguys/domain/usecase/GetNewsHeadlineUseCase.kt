package com.dzakyhdr.beritaguys.domain.usecase

import com.dzakyhdr.beritaguys.data.model.APIResponse
import com.dzakyhdr.beritaguys.data.util.Resource
import com.dzakyhdr.beritaguys.domain.repository.NewsRepository

class GetNewsHeadlineUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<APIResponse>{
        return newsRepository.getNewsHeadline()
    }
}
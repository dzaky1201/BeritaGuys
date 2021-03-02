package com.dzakyhdr.beritaguys.domain.repository

import com.dzakyhdr.beritaguys.data.model.APIResponse
import com.dzakyhdr.beritaguys.data.model.Article
import com.dzakyhdr.beritaguys.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadline(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchNews(searchQuery: String): Resource<APIResponse>
    suspend fun savedNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}
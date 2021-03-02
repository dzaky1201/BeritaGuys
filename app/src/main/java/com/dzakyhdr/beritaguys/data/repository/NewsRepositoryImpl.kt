package com.dzakyhdr.beritaguys.data.repository

import com.dzakyhdr.beritaguys.data.model.APIResponse
import com.dzakyhdr.beritaguys.data.model.Article
import com.dzakyhdr.beritaguys.data.repository.datasource.NewsRemoteDataSource
import com.dzakyhdr.beritaguys.data.util.Resource
import com.dzakyhdr.beritaguys.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(private val remoteDataSource: NewsRemoteDataSource) : NewsRepository {

    override suspend fun getNewsHeadline(country: String, page: Int): Resource<APIResponse> {
        return responseToResource(remoteDataSource.getTopHeadlines(country, page))
    }


    override suspend fun getSearchNews(searchQuery: String): Resource<APIResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun savedNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

    private fun responseToResource(response: Response<APIResponse>): Resource<APIResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }

        return Resource.Error(response.message())
    }
}
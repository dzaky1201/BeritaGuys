package com.dzakyhdr.beritaguys.data.repository.datasourceImpl

import com.dzakyhdr.beritaguys.data.api.NewsAPIService
import com.dzakyhdr.beritaguys.data.model.APIResponse
import com.dzakyhdr.beritaguys.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}
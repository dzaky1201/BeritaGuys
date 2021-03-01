package com.dzakyhdr.beritaguys.data.repository.datasource

import com.dzakyhdr.beritaguys.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(): Response<APIResponse>
}
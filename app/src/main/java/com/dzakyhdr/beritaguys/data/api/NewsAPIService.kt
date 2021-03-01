package com.dzakyhdr.beritaguys.data.api

import com.dzakyhdr.beritaguys.BuildConfig
import com.dzakyhdr.beritaguys.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {
    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY
    ): Response<APIResponse>
}
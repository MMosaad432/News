package com.task.news.features.newslist.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("news")
    suspend fun getNews(
        @Query("apikey") apiKey: String,
        @Query("country") country: String? = null,
        @Query("language") language: String? = null,
        @Query("page") page: String? = null,
        @Query("size") size: Int? = null
    ): NewsResponse
}
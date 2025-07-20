package com.task.news.features.newslist.data.remote.source

import com.task.news.core.utils.Constants
import com.task.news.features.newslist.data.remote.NewsApi
import com.task.news.features.newslist.data.remote.NewsResponse
import javax.inject.Inject

class NewsListRemoteDataSource @Inject constructor(
    private val newsApi: NewsApi
) {
    suspend fun getNews(
        page: String? = null,
        country: String = Constants.DEFAULT_COUNTRY,
        lang: String = Constants.DEFAULT_LANGUAGE,
    ): NewsResponse {
        return newsApi.getNews(
            apiKey = Constants.NEWS_API_KEY,
            country = country,
            language = lang,
            page = page,
            size = Constants.DEFAULT_PAGE_SIZE
        )
    }
}
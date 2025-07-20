package com.task.news.features.newslist.data.repository

import com.task.news.core.mapper.toArticleItem
import com.task.news.core.utils.Constants
import com.task.news.features.newslist.data.model.ArticleItem
import com.task.news.features.newslist.data.remote.NewsApi
import javax.inject.Inject

class NewsListRepository @Inject constructor(private val newsApi: NewsApi) : INewsListRepository {
    override suspend fun getNews(): List<ArticleItem> =
        newsApi.getNews(Constants.NEWS_API_KEY, "eg").results.map { it.toArticleItem() }

}
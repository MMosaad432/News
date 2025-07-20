package com.task.news.features.newsdetails.data.repository

import com.task.news.core.mapper.toArticleItem
import com.task.news.features.newsdetails.data.source.ArticleDetailLocalDataSource
import com.task.news.features.newslist.data.model.ArticleItem
import javax.inject.Inject

class ArticleDetailRepository @Inject constructor(
    private val localDataSource: ArticleDetailLocalDataSource
) : IArticleDetailRepository {
    override suspend fun getArticleById(id: String): ArticleItem? {
        return localDataSource.getArticleById(id)?.toArticleItem()
    }
}
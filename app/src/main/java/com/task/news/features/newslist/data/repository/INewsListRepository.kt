package com.task.news.features.newslist.data.repository

import com.task.news.features.newslist.data.model.ArticleItem

interface INewsListRepository {
    suspend fun getNews(): List<ArticleItem>
}
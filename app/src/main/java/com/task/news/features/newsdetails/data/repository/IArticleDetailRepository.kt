package com.task.news.features.newsdetails.data.repository

import com.task.news.features.newslist.data.model.ArticleItem

interface IArticleDetailRepository {
    suspend fun getArticleById(id: String): ArticleItem?
}
package com.task.news.features.newslist.data.model

data class ArticleItem(
    val id: String,
    val title: String,
    val description: String?,
    val content: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val sourceId: String?,
    val sourceName: String
)
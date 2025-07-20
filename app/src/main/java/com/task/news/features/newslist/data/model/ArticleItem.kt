package com.task.news.features.newslist.data.model

data class ArticleItem(
    val id: String,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val sourceName: String
)
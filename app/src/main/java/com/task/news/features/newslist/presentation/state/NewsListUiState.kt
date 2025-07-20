package com.task.news.features.newslist.presentation.state

import com.task.news.features.newslist.data.model.ArticleItem

data class NewsListUiState(
    val news: List<ArticleItem>? = null
)
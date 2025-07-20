package com.task.news.features.newsdetails.presentation.state

import com.task.news.features.newslist.data.model.ArticleItem

data class ArticleDetailUiState(
    val isLoading: Boolean = false,
    val article: ArticleItem? = null,
    val error: String? = null
)
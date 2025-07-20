package com.task.news.features.newslist.presentation.state

import androidx.paging.PagingData
import com.task.news.features.newslist.data.model.ArticleItem
import kotlinx.coroutines.flow.Flow

data class NewsListUiState(
    val news: Flow<PagingData<ArticleItem>>? = null
)
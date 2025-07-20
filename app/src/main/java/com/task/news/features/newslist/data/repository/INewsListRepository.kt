package com.task.news.features.newslist.data.repository

import androidx.paging.PagingData
import com.task.news.features.newslist.data.model.ArticleItem
import kotlinx.coroutines.flow.Flow

interface INewsListRepository {

    fun getNews(): Flow<PagingData<ArticleItem>>
}
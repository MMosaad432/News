package com.task.news.features.newslist.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.task.news.core.utils.Constants
import com.task.news.features.newslist.data.local.source.NewsListLocalDataSource
import com.task.news.features.newslist.data.model.ArticleItem
import com.task.news.features.newslist.data.remote.source.NewsListRemoteDataSource
import com.task.news.features.newslist.data.source.NewsPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsListRepository @Inject constructor(
    private val remoteDataSource: NewsListRemoteDataSource,
    private val localDataSource: NewsListLocalDataSource
) : INewsListRepository {

    override fun getNews(): Flow<PagingData<ArticleItem>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.DEFAULT_PAGE_SIZE,
                enablePlaceholders = false,
                prefetchDistance = 2
            ),
            pagingSourceFactory = {
                NewsPagingSource(remoteDataSource, localDataSource)
            }
        ).flow
    }
}
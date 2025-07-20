package com.task.news.features.newslist.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.task.news.core.mapper.toArticleItem
import com.task.news.core.mapper.toEntity
import com.task.news.features.newslist.data.local.source.NewsListLocalDataSource
import com.task.news.features.newslist.data.model.ArticleItem
import com.task.news.features.newslist.data.remote.source.NewsListRemoteDataSource

class NewsPagingSource(
    private val remoteDataSource: NewsListRemoteDataSource,
    private val localDataSource: NewsListLocalDataSource
) : PagingSource<String, ArticleItem>() {

    override suspend fun load(params: LoadParams<String>): LoadResult<String, ArticleItem> {
        return try {
            val pageKey = params.key
            val response = remoteDataSource.getNews(page = pageKey)
            val entities = response.results.map { it.toEntity() }

            if (pageKey == null && response.status == "success") {
                localDataSource.clearAllArticles()
            }
            if (entities.isNotEmpty()) {
                localDataSource.insertArticles(entities)
            }

            val articles = entities.map { it.toArticleItem() }

            LoadResult.Page(
                data = articles,
                prevKey = null,
                nextKey = response.nextPage
            )
        } catch (e: Exception) {
            if (params.key == null) {
                try {
                    val cachedArticles = localDataSource.getAllArticles()
                        .map { it.toArticleItem() }

                    if (cachedArticles.isNotEmpty()) {
                        LoadResult.Page(
                            data = cachedArticles,
                            prevKey = null,
                            nextKey = null
                        )
                    } else {
                        LoadResult.Error(e)
                    }
                } catch (dbError: Exception) {
                    LoadResult.Error(e)
                }
            } else {
                LoadResult.Error(e)
            }
        }
    }

    override fun getRefreshKey(state: PagingState<String, ArticleItem>): String? {
        return null
    }
}
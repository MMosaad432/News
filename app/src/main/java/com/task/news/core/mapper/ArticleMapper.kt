package com.task.news.core.mapper

import com.task.news.features.newslist.data.local.entities.ArticleEntity
import com.task.news.features.newslist.data.model.ArticleItem
import com.task.news.features.newslist.data.remote.Article

fun Article.toEntity(): ArticleEntity {
    val id = articleId ?: link.hashCode().toString()
    return ArticleEntity(
        id = id,
        title = title.orEmpty(),
        description = description,
        url = link,
        urlToImage = imageUrl,
        sourceName = sourceName.orEmpty()
    )
}

fun ArticleEntity.toArticleItem(): ArticleItem = ArticleItem(
    id = id,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    sourceName = sourceName
)
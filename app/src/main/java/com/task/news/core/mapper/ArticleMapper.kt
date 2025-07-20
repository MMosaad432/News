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
        content = content ?: description.orEmpty(),
        url = link.orEmpty(),
        urlToImage = imageUrl,
        publishedAt = pubDate.orEmpty(),
        sourceName = sourceId.orEmpty(),
        sourceId = sourceId
    )
}

fun ArticleEntity.toArticleItem(): ArticleItem = ArticleItem(
    id = id,
    title = title,
    description = description,
    content = content,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    sourceName = sourceName,
    sourceId = sourceId
)
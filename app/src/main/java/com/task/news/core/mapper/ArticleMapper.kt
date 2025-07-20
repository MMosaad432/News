package com.task.news.core.mapper

import com.task.news.features.newslist.data.model.ArticleItem
import com.task.news.features.newslist.data.remote.Article

fun Article.toArticleItem() = ArticleItem(
    id = articleId.orEmpty(),
    title = title.orEmpty(),
    description = description.orEmpty(),
    content = content.orEmpty(),
    url = link.orEmpty(),
    urlToImage = imageUrl.orEmpty(),
    publishedAt = pubDate.orEmpty(),
    sourceName = sourceId.orEmpty(),
    sourceId = sourceId
)
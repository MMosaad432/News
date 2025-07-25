package com.task.news.features.newslist.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey val id: String,
    val title: String,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val sourceName: String
)
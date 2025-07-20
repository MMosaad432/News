package com.task.news.features.newsdetails.data.source

import androidx.room.Dao
import androidx.room.Query
import com.task.news.features.newslist.data.local.entities.ArticleEntity

@Dao
interface ArticleDetailLocalDataSource {
    @Query("SELECT * FROM articles WHERE id = :id")
    suspend fun getArticleById(id: String): ArticleEntity?
}
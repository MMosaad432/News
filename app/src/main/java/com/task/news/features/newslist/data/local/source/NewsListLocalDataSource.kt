package com.task.news.features.newslist.data.local.source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.task.news.features.newslist.data.local.entities.ArticleEntity

@Dao
interface NewsListLocalDataSource {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<ArticleEntity>)
    
    @Query("DELETE FROM articles")
    suspend fun clearAllArticles()

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<ArticleEntity>
}
package com.task.news.features.newslist.data.local.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.task.news.features.newsdetails.data.source.ArticleDetailLocalDataSource
import com.task.news.features.newslist.data.local.source.NewsListLocalDataSource

@Database(
    entities = [ArticleEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsListDao(): NewsListLocalDataSource
    abstract fun articleDetailDao(): ArticleDetailLocalDataSource
}
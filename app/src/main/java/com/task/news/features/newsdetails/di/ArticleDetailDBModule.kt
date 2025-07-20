package com.task.news.features.newsdetails.di

import com.task.news.features.newsdetails.data.source.ArticleDetailLocalDataSource
import com.task.news.features.newslist.data.local.entities.NewsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ArticleDetailDBModule {

    @Provides
    fun provideArticleDetailsDao(database: NewsDatabase): ArticleDetailLocalDataSource {
        return database.articleDetailDao()
    }
}
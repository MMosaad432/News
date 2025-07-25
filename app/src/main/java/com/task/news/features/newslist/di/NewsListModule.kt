package com.task.news.features.newslist.di

import com.task.news.features.newslist.data.local.entities.NewsDatabase
import com.task.news.features.newslist.data.local.source.NewsListLocalDataSource
import com.task.news.features.newslist.data.remote.NewsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsListModule {

    @Provides
    fun provideNewsListDao(database: NewsDatabase): NewsListLocalDataSource {
        return database.newsListDao()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)
}
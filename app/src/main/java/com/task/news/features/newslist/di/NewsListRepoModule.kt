package com.task.news.features.newslist.di

import com.task.news.features.newslist.data.repository.INewsListRepository
import com.task.news.features.newslist.data.repository.NewsListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class NewsListRepoModule {
    @Binds
    abstract fun bindsNewsRepository(newsListRepository: NewsListRepository): INewsListRepository
}
package com.task.news.features.newsdetails.di

import com.task.news.features.newsdetails.data.repository.ArticleDetailRepository
import com.task.news.features.newsdetails.data.repository.IArticleDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ArticleDetailRepoModule {
    @Binds
    abstract fun bindArticleDetailsRepository(articleDetailRepository: ArticleDetailRepository): IArticleDetailRepository
}
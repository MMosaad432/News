package com.task.news.features.newslist.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.task.news.core.components.NewsTopBar
import com.task.news.features.newslist.data.model.ArticleItem
import com.task.news.features.newslist.presentation.ui.components.NewsListItem
import com.task.news.features.newslist.presentation.viewmodel.NewsListViewModel

@Composable
fun NewsListScreen(viewModel: NewsListViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    uiState.news?.let { news ->
        NewsListContent(news)
    }
    Scaffold(
        topBar = {
            NewsTopBar(
                title = "World News",
                showBackButton = false
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            uiState.news?.let { news ->
                NewsListContent(
                    news = news
                )
            }
        }
    }
}

@Composable
fun NewsListContent(news: List<ArticleItem>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(news) {
            NewsListItem(it, {})
        }
    }
}
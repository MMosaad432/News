package com.task.news.features.newsdetails.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.task.news.core.components.LoadingContent
import com.task.news.core.components.NewsTopBar
import com.task.news.features.newsdetails.presentation.state.ArticleDetailUiState
import com.task.news.features.newsdetails.presentation.ui.components.ArticleDetailSuccessContent
import com.task.news.features.newsdetails.presentation.ui.components.ErrorContent
import com.task.news.features.newsdetails.presentation.viewmodel.ArticleDetailsViewModel

@Composable
fun ArticleDetailScreen(
    articleId: String,
    onNavigateBack: () -> Unit,
    viewModel: ArticleDetailsViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(articleId) {
        viewModel.loadArticle(articleId)
    }

    uiState.error?.let { error ->
        LaunchedEffect(error) {
            snackbarHostState.showSnackbar(error)
            viewModel.clearError()
        }
    }

    Scaffold(
        topBar = {
            NewsTopBar(
                title = "Article",
                showBackButton = true,
                onBackClick = onNavigateBack
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        ArticleDetailContent(
            uiState = uiState,
            modifier = Modifier.padding(paddingValues),
            onRetry = {
                viewModel.loadArticle(articleId)
            }
        )
    }
}

@Composable
fun ArticleDetailContent(
    uiState: ArticleDetailUiState,
    modifier: Modifier = Modifier,
    onRetry: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        when {
            uiState.isLoading -> {
                LoadingContent(message = "Loading article...")
            }

            uiState.error != null && uiState.article == null -> {
                ErrorContent(
                    error = uiState.error,
                    onRetry = onRetry
                )
            }

            uiState.article != null -> {
                ArticleDetailSuccessContent(article = uiState.article)
            }
        }
    }
}
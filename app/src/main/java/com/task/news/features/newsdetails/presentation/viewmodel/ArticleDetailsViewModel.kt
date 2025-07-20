package com.task.news.features.newsdetails.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.news.features.newsdetails.data.repository.IArticleDetailRepository
import com.task.news.features.newsdetails.presentation.state.ArticleDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor(
    private val repository: IArticleDetailRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ArticleDetailUiState())
    val uiState: StateFlow<ArticleDetailUiState> = _uiState.asStateFlow()

    fun loadArticle(articleId: String) {
        viewModelScope.launch {
            try {
                _uiState.value = _uiState.value.copy(
                    isLoading = true,
                    error = null
                )

                val article = repository.getArticleById(articleId)
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    article = article,
                    error = if (article == null) "Article not found" else null
                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    article = null,
                    error = "Failed to load article: ${e.message}"
                )
            }
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
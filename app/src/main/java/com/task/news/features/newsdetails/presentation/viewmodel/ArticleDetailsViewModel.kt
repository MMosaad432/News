package com.task.news.features.newsdetails.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.news.features.newsdetails.presentation.state.ArticleDetailUiState
import com.task.news.features.newslist.data.model.ArticleItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailsViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ArticleDetailUiState())
    val uiState: StateFlow<ArticleDetailUiState> = _uiState.asStateFlow()
     fun loadArticle(articleId: String) {
        viewModelScope.launch {
            delay(4000)
            _uiState.value = _uiState.value.copy(
                article = ArticleItem(
                    "1",
                    "Tittleee",
                    "DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION DESCRRRIIPTTION",
                    "Content Content Content Content Content Content Content Content Content Content Content Content ",
                    "",
                    "https://img.egypt-today.com/2022/03/normal/pound.jpg",
                    "",
                    "",
                    "SOURCE"
                )
            )
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}
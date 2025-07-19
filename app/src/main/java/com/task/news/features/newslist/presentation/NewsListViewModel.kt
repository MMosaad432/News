package com.task.news.features.newslist.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(NewsListUiState())
    val uiState: StateFlow<NewsListUiState> = _uiState.asStateFlow()
    init {
        loadNews()
    }

    private fun loadNews() {
        _uiState.value = _uiState.value.copy(
            news = listOf("News 1","News 2","News 3","News 4","News 5","News 6","News 7","News 8")
        )
    }
}
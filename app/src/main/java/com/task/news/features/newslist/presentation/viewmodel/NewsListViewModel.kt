package com.task.news.features.newslist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.task.news.core.utils.NetworkObserver
import com.task.news.features.newslist.data.repository.INewsListRepository
import com.task.news.features.newslist.presentation.state.NewsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsListRepository: INewsListRepository,
    private val networkObserver: NetworkObserver
) : ViewModel() {
    private var refreshTrigger = MutableStateFlow(true)
    private val _uiState = MutableStateFlow(
        NewsListUiState(
            news = refreshTrigger.flatMapLatest {
                newsListRepository.getNews()
            }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
                .cachedIn(viewModelScope)
        )
    )
    val uiState: StateFlow<NewsListUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            networkObserver.isConnected.collect { connected ->
                if (connected) refreshNews()
            }
        }
    }

    private fun refreshNews() {
        refreshTrigger.value = !refreshTrigger.value
    }
}
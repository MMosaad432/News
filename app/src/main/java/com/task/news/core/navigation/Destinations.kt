package com.task.news.core.navigation

sealed class Destinations(val route: String) {
    data object NewsList : Destinations("news_list")
}
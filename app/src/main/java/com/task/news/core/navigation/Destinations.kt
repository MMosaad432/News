package com.task.news.core.navigation

sealed class Destinations(val route: String) {
    data object NewsList : Destinations("news_list")

    data object ArticleDetails : Destinations("article_detail/{articleId}") {
        fun createRoute(articleId: String): String {
            return route.replace("{articleId}", articleId)
        }
    }
}
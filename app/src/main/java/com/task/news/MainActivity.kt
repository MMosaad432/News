package com.task.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.task.news.core.navigation.Destinations
import com.task.news.features.newsdetails.presentation.ui.ArticleDetailScreen
import com.task.news.features.newslist.presentation.ui.NewsListScreen
import com.task.news.ui.theme.NewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Destinations.NewsList.route
                    ) {
                        composable(Destinations.NewsList.route) {
                            NewsListScreen(
                                onArticleClicked = { articleId ->
                                    navController.navigate(
                                        Destinations.ArticleDetails.createRoute(
                                            articleId
                                        )
                                    )
                                }
                            )
                        }

                        composable(
                            route = Destinations.ArticleDetails.route,
                            arguments = listOf(navArgument("articleId") {
                                type = NavType.StringType
                            })
                        ) { backStackEntry ->
                            val articleId = backStackEntry.arguments?.getString("articleId")
                                ?: return@composable
                            ArticleDetailScreen(
                                articleId = articleId,
                                onNavigateBack = {
                                    navController.popBackStack()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
package com.taufik.aseannatocompose.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("home/{detailId}") {
        fun createRoute(detailId: Int) = "home/$detailId"
    }
}
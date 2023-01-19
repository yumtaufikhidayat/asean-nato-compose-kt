package com.taufik.aseannatocompose.navigation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Detail: Screen("home/{detailId}") {
        fun createRoute(detailId: Int) = "home/$detailId"
    }
    object Profile: Screen("profile")
}
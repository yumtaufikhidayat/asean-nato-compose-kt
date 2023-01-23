package com.taufik.aseannatocompose.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.taufik.aseannatocompose.R
import com.taufik.aseannatocompose.navigation.Screen
import com.taufik.aseannatocompose.ui.components.ToolbarHeader
import com.taufik.aseannatocompose.ui.screen.detail.DetailCountryScreen
import com.taufik.aseannatocompose.ui.screen.home.HomeScreen
import com.taufik.aseannatocompose.ui.screen.profile.ProfileScreen
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AseanNatoApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val topBarState = rememberSaveable { (mutableStateOf(true)) }
    val iconState = rememberSaveable { (mutableStateOf(true)) }

    when (currentRoute) {
        Screen.Home.route -> {
            topBarState.value = true
            iconState.value = true
        }
        Screen.Detail.route -> {
            topBarState.value = true
            iconState.value = false
        }
        Screen.Profile.route -> {
            topBarState.value = true
            iconState.value = false
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                navController = navController,
                topBarState = topBarState,
                iconState = iconState
            )
        },
        content = { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
                modifier = modifier.padding(paddingValues)
            ) {
                composable(route = Screen.Home.route) {
                    HomeScreen(
                        navigateToDetail = {
                            navController.navigate(Screen.Detail.createRoute(it))
                        }
                    )
                }

                composable(
                    route = Screen.Detail.route,
                    arguments = listOf(navArgument("detailId") { type = NavType.IntType }),
                ) {
                    val id = it.arguments?.getInt("detailId") ?: 0
                    DetailCountryScreen(
                        detailId = id
                    )
                }

                composable(route = Screen.Profile.route) {
                    ProfileScreen()
                }
            }
        }
    )
}

@ExperimentalAnimationApi
@Composable
fun TopBar(
    navController: NavController,
    topBarState: MutableState<Boolean>,
    iconState: MutableState<Boolean>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val title: String = when (navBackStackEntry?.destination?.route ?: Screen.Home.route) {
        Screen.Home.route -> stringResource(id = R.string.app_name)
        Screen.Detail.route -> ""
        Screen.Profile.route -> stringResource(id = R.string.profile)
        else -> stringResource(id = R.string.app_name)
    }

    AnimatedVisibility(
        visible = topBarState.value,
        enter = slideInVertically(initialOffsetY = { -it }),
        exit = slideOutVertically(targetOffsetY = { -it }),
        content = {
            ToolbarHeader(
                title = title,
                navigateToProfile = {
                    navController.navigate(Screen.Profile.route)
                },
                iconState = iconState
            )
        }
    )
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun AseanNatoAppPreview() {
    AseanNatoComposeTheme {
        AseanNatoApp()
    }
}
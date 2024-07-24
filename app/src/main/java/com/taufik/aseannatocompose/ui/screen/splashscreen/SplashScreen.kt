package com.taufik.aseannatocompose.ui.screen.splashscreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.taufik.aseannatocompose.R
import com.taufik.aseannatocompose.navigation.Screen
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavHostController
) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route)
    }
    SplashContent(alpha = alphaAnim.value)
}

@Composable
fun SplashContent(
    modifier: Modifier = Modifier,
    alpha: Float
) {
    Box(
        modifier = modifier
            .background(colorResource(id = R.color.purple_700))
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.asean_logo),
                contentDescription = null,
                modifier = modifier.size(100.dp).alpha(alpha)
            )
            Spacer(modifier = modifier.padding(10.dp))
            Image(
                painter = painterResource(id = R.drawable.nato_logo),
                contentDescription = null,
                modifier = modifier.size(100.dp).alpha(alpha)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun SplashScreenPreview() {
    AseanNatoComposeTheme {
        SplashContent(alpha = 1f)
    }
}
package com.taufik.aseannatocompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.taufik.aseannatocompose.R
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@Composable
fun ToolbarHeader(
    modifier: Modifier = Modifier,
    navigateToProfile: () -> Unit,
    title: String,
    iconState: MutableState<Boolean> = rememberSaveable { (mutableStateOf(true)) }
) {
    if (iconState.value) {
        TopAppBar(
            title = {
                Text(text = title)
            },
            elevation = 0.dp,
            actions = {
                IconButton(onClick = {
                    navigateToProfile()
                }) {
                    Icon(painter = painterResource(id = R.drawable.ic_account), contentDescription = null)
                }
            },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            modifier = modifier.fillMaxWidth()
        )
    } else {
        TopAppBar(
            title = {
                Text(text = title)
            },
            elevation = 0.dp,
            backgroundColor = MaterialTheme.colors.primaryVariant,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarHeaderPreview() {
    AseanNatoComposeTheme {
        ToolbarHeader(title = "ASEAN-NATO Countries", navigateToProfile = {})
    }
}
package com.taufik.aseannatocompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@Composable
fun ToolbarHeader(
    title: String = "",
    modifier: Modifier = Modifier
) {
    Column {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    textAlign = TextAlign.Center
                )
            },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarHeaderPreview() {
    AseanNatoComposeTheme {
        ToolbarHeader("ASEAN-NATO Countries")
    }
}
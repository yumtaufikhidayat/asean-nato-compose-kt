package com.taufik.aseannatocompose.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.taufik.aseancompose.R
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@Composable
fun ToolbarHeader(
    modifier: Modifier = Modifier,
    title: String = "",
    context: Context = LocalContext.current,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center
            )
        },
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Profil", Toast.LENGTH_SHORT).show()
            }) {
                Icon(painter = painterResource(id = R.drawable.ic_account), contentDescription = null)
            }
        },
        backgroundColor = MaterialTheme.colors.primaryVariant,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview(showBackground = true)
@Composable
fun ToolbarHeaderPreview() {
    AseanNatoComposeTheme {
        ToolbarHeader(title = "ASEAN-NATO Countries")
    }
}
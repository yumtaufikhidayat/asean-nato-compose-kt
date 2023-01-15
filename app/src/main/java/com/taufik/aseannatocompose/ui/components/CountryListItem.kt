package com.taufik.aseannatocompose.ui.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CountryListItem(
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    countryName: String = "",
    countryInternationalName: String = "",
    countryFlagUrl: String  = "",
    countryDescription: String  = "",
    countryHeadGovernment: String  = "",
    countryCapital: String  = "",
    countryIndependenceDay: String  = "",
    countryLanguage: String  = "",
    countryCurrency: String  = "",
    countryLandArea: String  = ""
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            Toast.makeText(context, countryName, Toast.LENGTH_SHORT).show()
        }
    ) {
        AsyncImage(
            model = countryFlagUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
        ) {
            Text(
                text = countryName,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(end = 16.dp),
            )
            Text(
                text = countryInternationalName,
                fontWeight = FontWeight.Normal,
                modifier = modifier.padding(end = 16.dp),
            )
        }
    }
}


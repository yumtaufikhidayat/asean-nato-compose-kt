package com.taufik.aseannatocompose.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.taufik.aseannatocompose.R
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@Composable
fun CountryListItem(
    countryName: String,
    countryInternationalName: String,
    countryFlagUrl: String,
    countryDescription: String,
    countryHeadGovernment: String,
    countryCapital: String,
    countryIndependenceDay: String,
    countryLanguage: String,
    countryCurrency: String,
    countryLandArea: String,
    modifier: Modifier = Modifier,
    isShow: Boolean = true,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        AsyncImage(
            model = countryFlagUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_solid_purple),
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
                .border(
                    border = BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                    shape = CircleShape
                )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp),
        ) {
            if (isShow) {
                Text(
                    text = countryName,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = countryInternationalName,
                    fontStyle = FontStyle.Italic,
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    modifier = modifier.padding(end = 16.dp),
                )
            } else {
                Text(
                    text = countryDescription,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = countryHeadGovernment,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = countryCapital,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = countryIndependenceDay,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = countryLanguage,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = countryCurrency,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = countryLandArea,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AseanNatoAppPreview() {
    AseanNatoComposeTheme {
        CountryListItem(
            countryName = "Indonesia",
            countryInternationalName = "Republik Indonesia",
            countryFlagUrl = "",
            countryDescription = "",
            countryHeadGovernment = "",
            countryCapital = "",
            countryIndependenceDay = "",
            countryLanguage = "",
            countryCurrency = "",
            countryLandArea = "",
        )
    }
}
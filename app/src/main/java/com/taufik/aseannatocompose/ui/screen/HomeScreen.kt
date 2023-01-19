package com.taufik.aseannatocompose.ui.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import com.taufik.aseannatocompose.model.Country
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToDetail: (Int) -> Unit,
    country: Country
) {
    CountryListItem(
        country = country,
        modifier = modifier,
        navigateToDetail = {
            navigateToDetail(country.countryId)
        }
    )
}

@Composable
fun CountryListItem(
    modifier: Modifier = Modifier,
    country: Country,
    isShow: Boolean = true,
    navigateToDetail: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.clickable {
            navigateToDetail(country.countryId)
        },
    ) {
        AsyncImage(
            model = country.countryFlagUrl,
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
                    text = country.countryName,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = country.countryInternationalName,
                    fontStyle = FontStyle.Italic,
                    modifier = modifier.padding(end = 16.dp),
                )
            } else {
                Text(
                    text = country.countryDescription,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = country.countryHeadGovernment,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = country.countryCapital,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = country.countryIndependenceDay,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = country.countryLanguage,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = country.countryCurrency,
                    fontWeight = FontWeight.Normal,
                    modifier = modifier.padding(end = 16.dp),
                )
                Text(
                    text = country.countryLandArea,
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
            country = Country(
                countryName = "Indonesia",
                countryInternationalName = "Republik Indonesia",
            ),
            isShow = true,
            navigateToDetail = {}
        )
    }
}
package com.taufik.aseannatocompose.ui.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.taufik.aseannatocompose.R
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@Composable
fun DetailCountryScreen(
    modifier: Modifier = Modifier,
    detailId: Int = 0
) {
    /*DetailContent(
        modifier,
        detailId,
    )*/
}

@Composable
fun DetailContent(
    modifier: Modifier = Modifier,
    detailId: Int,
    countryImage: String,
    countryName: String,
    countryInternationalName: String,
    countryDescription: String,
    countryCapital: String,
    countryHeadGovernment: String,
    countryIndependenceDay: String,
    countryLanguage: String,
    countryCurrency: String,
    countryLandArea: String
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.verticalScroll(
            state = scrollState,
        )
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = modifier
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        top = 60.dp,
                        bottom = 18.dp,
                        start = 16.dp,
                        end = 16.dp
                    ),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                Column(
                    modifier = modifier,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = countryName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        modifier = modifier.padding(
                            top = 48.dp,
                        )
                    )
                    Text(
                        text = countryInternationalName,
                        fontStyle = FontStyle.Italic,
                        modifier = modifier.padding(
                            bottom = 16.dp
                        )
                    )
                    Text(
                        text = countryDescription,
                        fontSize = 16.sp,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = 8.dp,
                                start = 16.dp,
                                end = 16.dp,
                            )
                    )
                    Column(
                        modifier = modifier
                    ) {
                        Text(
                            text = stringResource(id = R.string.text_summary),
                            fontWeight = FontWeight.Bold,
                            modifier = modifier
                                .padding(
                                    top = 8.dp,
                                    bottom = 8.dp,
                                    start = 16.dp,
                                )
                                .fillMaxWidth()
                        )
                        Row(
                            modifier = modifier.padding(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_outline_office),
                                contentDescription = stringResource(id = R.string.text_capital),
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .border(
                                        BorderStroke(4.dp, MaterialTheme.colors.primaryVariant),
                                        CircleShape
                                    )
                                    .background(
                                        color = MaterialTheme.colors.primaryVariant,
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_capital),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = countryCapital,
                                    fontStyle = FontStyle.Normal,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(top = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_head_government),
                                contentDescription = stringResource(id = R.string.text_head_government),
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .border(
                                        BorderStroke(2.dp, colorResource(R.color.red)),
                                        CircleShape
                                    )
                                    .background(
                                        color = colorResource(R.color.red),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_head_government),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = countryHeadGovernment,
                                    fontStyle = FontStyle.Normal,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(top = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_outline_calendar),
                                contentDescription = stringResource(id = R.string.text_independence_day),
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .border(
                                        BorderStroke(2.dp, colorResource(id = R.color.blue)),
                                        CircleShape
                                    )
                                    .background(
                                        color = colorResource(id = R.color.blue),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_independence_day),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = countryIndependenceDay,
                                    fontStyle = FontStyle.Normal,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(top = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_outline_language),
                                contentDescription = stringResource(id = R.string.text_official_language),
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .border(
                                        BorderStroke(2.dp, colorResource(id = R.color.orange)),
                                        CircleShape
                                    )
                                    .background(
                                        color = colorResource(id = R.color.orange),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_official_language),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                    )
                                )
                                Text(
                                    text = countryLanguage,
                                    fontStyle = FontStyle.Normal,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(top = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_outline_currency),
                                contentDescription = stringResource(id = R.string.text_currency),
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .border(
                                        BorderStroke(2.dp, colorResource(id = R.color.green)),
                                        CircleShape
                                    )
                                    .background(
                                        color = colorResource(id = R.color.green),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_currency),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = countryCurrency,
                                    fontStyle = FontStyle.Normal,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(
                                top = 16.dp,
                                bottom = 16.dp
                            )
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_outline_land_area),
                                contentDescription = stringResource(id = R.string.text_land_area),
                                contentScale = ContentScale.Crop,
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .border(
                                        BorderStroke(2.dp, colorResource(id = R.color.yellow)),
                                        CircleShape
                                    )
                                    .background(
                                        color = colorResource(id = R.color.yellow),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            )
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_land_area),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = countryLandArea,
                                    fontStyle = FontStyle.Normal,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                            }
                        }
                    }
                }
            }
            AsyncImage(
                model = countryImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_solid_purple),
                modifier = Modifier
                    .padding(8.dp)
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(
                        border = BorderStroke(2.dp, MaterialTheme.colors.primaryVariant),
                        shape = CircleShape
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    AseanNatoComposeTheme {
        DetailContent(
            modifier = Modifier,
            detailId = 0,
            countryImage = "",
            countryName = "Indonesia",
            countryInternationalName = "Republik Indonesia",
            countryDescription = "Negara kepulauan dengan total penduduk sekitar 272.229.372 jiwa (per Juni 2021) ini memiliki wilayah yang ada di antara benua Asia dan Australia. Posisi geografis yang berada sebagai titik silang perekonomian dunia ini pun sangat berpengaruh terhadap aktivitas perdagangan Indonesia. Menelisik sejarahnya, Indonesia sempat mengalami pahitnya kolonialisme Belanda dan juga Jepang selama lebih dari 300 tahun. Setelah Jepang kalah di Perang Dunia II, Republik Indonesia akhirnya berdiri menjadi negara yang merdeka sejak 17 Agustus 1945. Setelah 76 tahun Indonesia merdeka, negara dengan ibu kota Jakarta ini dipimpin oleh Presiden Joko Widodo. Ini bukanlah kali pertama Presiden Joko Widodo menjabat sebagai kepala negara. Setelah masa jabatannya habis di tahun 2019, Joko widodo kembali memenangkan pemilihan umum di tahun yang sama. Republik dengan bentuk negara kesatuan ini memiliki ideologi Pancasila yang sekaligus menjadi pedoman bagi seluruh warganya. Berasas demokrasi, Indonesia memiliki sistem pemerintahan presidensial.",
            countryCapital = "Jakarta",
            countryHeadGovernment = "Joko Widodo (Presiden)",
            countryIndependenceDay = "17 Agustus",
            countryLanguage = "Bahasa Indonesia",
            countryCurrency = "Rupiah",
            countryLandArea = "1.904.569"
        )
    }
}
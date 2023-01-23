package com.taufik.aseannatocompose.ui.screen.profile

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
import com.taufik.aseannatocompose.R
import com.taufik.aseannatocompose.ui.theme.AseanNatoComposeTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    ProfileContent(
        modifier = modifier
    )
}

@Composable
fun ProfileContent(
    modifier: Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(
                state = scrollState,
            )
            .background(color = MaterialTheme.colors.primaryVariant)
    ) {
        Box(
            contentAlignment = Alignment.TopCenter
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.text_profile_name),
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        modifier = modifier.padding(
                            top = 48.dp,
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.text_profile_job_position),
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        modifier = modifier.padding(
                            bottom = 16.dp
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.text_profile_about),
                        fontSize = MaterialTheme.typography.body1.fontSize,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(
                                bottom = 8.dp,
                                start = 16.dp,
                                end = 16.dp,
                            )
                    )
                    Column {
                        Text(
                            text = stringResource(id = R.string.about),
                            fontSize = MaterialTheme.typography.body1.fontSize,
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
                            Box(
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .background(
                                        color = MaterialTheme.colors.primaryVariant,
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_outline_email),
                                    contentDescription = stringResource(id = R.string.text_profile_email),
                                    contentScale = ContentScale.Crop,
                                    modifier = modifier
                                        .padding(10.dp)
                                        .size(20.dp)
                                )
                            }
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_profile_email),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = MaterialTheme.typography.body1.fontSize,
                                    modifier = modifier.padding(
                                        start = 15.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.text_profile_email_address),
                                    fontStyle = FontStyle.Normal,
                                    fontSize = MaterialTheme.typography.body2.fontSize,
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
                            Box(
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .background(
                                        color = colorResource(R.color.red),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_outline_office),
                                    contentDescription = stringResource(id = R.string.text_profile_office),
                                    contentScale = ContentScale.Crop,
                                    modifier = modifier
                                        .padding(10.dp)
                                        .size(20.dp)
                                )
                            }
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_profile_office),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = MaterialTheme.typography.body1.fontSize,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.text_profile_office_name),
                                    fontStyle = FontStyle.Normal,
                                    fontSize = MaterialTheme.typography.body2.fontSize,
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
                            Box(
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .background(
                                        color = colorResource(id = R.color.blue),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_linkedin),
                                    contentDescription = stringResource(id = R.string.text_profile_linkedIn),
                                    contentScale = ContentScale.Crop,
                                    modifier = modifier
                                        .padding(10.dp)
                                        .size(20.dp)
                                )
                            }
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_profile_linkedIn),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = MaterialTheme.typography.body1.fontSize,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.text_profile_linkedIn_account),
                                    fontStyle = FontStyle.Normal,
                                    fontSize = MaterialTheme.typography.body2.fontSize,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                    )
                                )
                            }
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier.padding(top = 16.dp, bottom = 24.dp)
                        ) {
                            Box(
                                modifier = modifier
                                    .padding(start = 16.dp)
                                    .background(
                                        color = colorResource(id = R.color.orange),
                                        shape = CircleShape
                                    )
                                    .size(40.dp)
                                    .clip(CircleShape)
                            ) {
                                Image(
                                    painter = painterResource(R.drawable.ic_github),
                                    contentDescription = stringResource(id = R.string.text_profile_github),
                                    contentScale = ContentScale.Crop,
                                    modifier = modifier
                                        .padding(10.dp)
                                        .size(20.dp)
                                )
                            }
                            Column(
                                modifier = modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = stringResource(id = R.string.text_profile_github),
                                    fontWeight = FontWeight.Bold,
                                    fontSize = MaterialTheme.typography.body1.fontSize,
                                    modifier = modifier.padding(
                                        start = 16.dp,
                                    )
                                )
                                Text(
                                    text = stringResource(id = R.string.text_profile_github_account),
                                    fontStyle = FontStyle.Normal,
                                    fontSize = MaterialTheme.typography.body2.fontSize,
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

            Image(
                painter = painterResource(id = R.drawable.pp_taufik),
                contentDescription = null,
                contentScale = ContentScale.Crop,
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
fun ProfileContentPreview() {
    AseanNatoComposeTheme {
        ProfileContent(
            modifier = Modifier
        )
    }
}
package com.example.unifyassignment.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifyassignment.R
import com.example.unifyassignment.data.response.DetailsResponse
import com.example.unifyassignment.ui.theme.ColorDivider
import com.example.unifyassignment.ui.theme.LightOrange
import com.example.unifyassignment.ui.theme.Orange

@Composable
fun DetailCard(detailsResponse: DetailsResponse) {
    Card(
        modifier = Modifier.padding(14.dp), elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .padding(start = 12.dp, top = 14.dp, bottom = 12.dp, end = 8.dp)
        ) {
            Row {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.str_valid_till),
                        color = Color.Black,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = detailsResponse.details?.valid_till ?: "",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Row {
                    Text(
                        text = stringResource(id = R.string.str_up_to_amount),
                        color = Color.Black,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = detailsResponse.details?.upto_amount ?: "",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
            Divider(
                color = ColorDivider,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
                    .padding(top = 12.dp, bottom = 12.dp)
            )
            Row {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = stringResource(id = R.string.str_frequency),
                        color = Color.Black,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Text(
                        text = detailsResponse.details?.frequency ?: "",
                        color = Color.Black,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Divider(
                color = ColorDivider,
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
                    .padding(top = 12.dp, bottom = 12.dp)
            )
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(LightOrange)
            ) {
                Row(Modifier.padding(8.dp)) {
                    Icon(

                        painter = painterResource(R.drawable.ic_info),
                        contentDescription = stringResource(id = R.string.info_icon),
                        tint = Orange,
                        modifier = Modifier
                            .padding(end = 5.dp)
                            .width(24.dp)
                            .height(24.dp)
                    )
                    Text(
                        text = detailsResponse.details?.warning_description ?: "",
                        fontSize = 11.sp,
                        lineHeight = 15.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}
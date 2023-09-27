package com.example.unifyassignment.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifyassignment.R
import com.example.unifyassignment.data.response.PayUsingItem
import com.example.unifyassignment.ui.theme.LightOrange

@Composable
fun PayUsingItem(data: PayUsingItem?) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, end = 14.dp, bottom = 12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        border = BorderStroke(2.dp, LightOrange),
        shape = RoundedCornerShape(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(42.dp)
                .background(
                    Color.White
                )
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_airtel),
                contentDescription = stringResource(id = R.string.str_bank_icon),
                tint = Color.Red,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(24.dp)
                    .width(24.dp)
                    .padding(
                        start = 10.dp, top = 5.dp, bottom = 5.dp
                    )
            )
            Text(
                text = data?.account ?: stringResource(id = R.string.str_default_account),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp)
                    .weight(1f),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis
            )
            Icon(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = stringResource(id = R.string.back_icon),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .rotate(180F)
                    .height(16.dp)
                    .width(16.dp)
            )
        }
    }
}
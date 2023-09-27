package com.example.unifyassignment.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.unifyassignment.R
import com.example.unifyassignment.data.response.DetailsResponse

@Composable
fun PaymentOption(detailsResponse: DetailsResponse) {
    val imageList = detailsResponse.payment_option ?: listOf()
    Column(modifier = Modifier.padding(start = 14.dp, top = 8.dp, bottom = 4.dp)) {
        Text(
            text = stringResource(id = R.string.str_auto_pay_payment_option),
            fontWeight = FontWeight.Bold,
        )

        LazyRow(content = {
            items(imageList) {
                PaymentOptionItem(data = it)
            }
        })
    }

}
package com.example.unifyassignment.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.unifyassignment.R
import com.example.unifyassignment.data.response.DetailsResponse

@Composable
fun PayUsing(detailsResponse: DetailsResponse) {
    val accountList = detailsResponse.pay_using ?: listOf()
    Column(
        modifier = Modifier
            .padding(start = 14.dp, top = 20.dp, bottom = 4.dp)
            .background(Color.White)
    ) {
        Text(text = stringResource(id = R.string.str_pay_using), fontWeight = FontWeight.Bold)
        LazyColumn {
            items(accountList) {
                PayUsingItem(data = it)
            }
        }

    }

}
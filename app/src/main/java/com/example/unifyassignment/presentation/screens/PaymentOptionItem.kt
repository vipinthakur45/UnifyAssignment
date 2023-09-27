package com.example.unifyassignment.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.unifyassignment.R
import com.example.unifyassignment.data.response.PaymentOptionItem
import com.example.unifyassignment.ui.theme.LightOrange
import com.example.unifyassignment.ui.theme.Orange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentOptionItem(data: PaymentOptionItem?) {
    var selectedCard by remember { mutableStateOf(false) }
    val borderColor = if (selectedCard) Orange else Color.White
    val backgroundColor = if (selectedCard) LightOrange else Color.White
    Card(modifier = Modifier
        .padding(end = 14.dp, top = 16.dp, start = 3.dp)
        .height(100.dp)
        .width(100.dp), elevation = CardDefaults.cardElevation(
        defaultElevation = 6.dp
    ), border = BorderStroke(2.dp, borderColor), onClick = {
        selectedCard = !selectedCard

    }) {
        Image(
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .background(backgroundColor)
                .padding(10.dp),
            painter = rememberAsyncImagePainter(data?.image_url),
            contentDescription = stringResource(id = R.string.str_option_img)
        )
    }
}
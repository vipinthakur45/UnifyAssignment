package com.example.unifyassignment.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.unifyassignment.data.response.DetailsResponse
import com.example.unifyassignment.presentation.screens.DetailCard
import com.example.unifyassignment.presentation.screens.Header
import com.example.unifyassignment.presentation.screens.PayUsing
import com.example.unifyassignment.presentation.screens.PaymentOption
import com.example.unifyassignment.ui.theme.UnifyAssignmentTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var detailsResponse: DetailsResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnifyAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Color.White
                ) {
                    App()
                }
            }
        }
    }


    @Composable
    fun App() {
        val detailsViewModel: DetailsViewModel = hiltViewModel()
        detailsViewModel.getDetails(error = {

        }, loading = {})
        val data = detailsViewModel.paymentDetailLiveData.observeAsState()
        data.value?.let {
            detailsResponse = it
            Column {
                Header()
                DetailCard(detailsResponse)
                PaymentOption(detailsResponse)
                PayUsing(detailsResponse)
            }
        }
    }

}



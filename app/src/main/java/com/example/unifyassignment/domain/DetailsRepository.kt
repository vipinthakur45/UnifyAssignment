package com.example.unifyassignment.domain

import com.example.unifyassignment.data.response.DetailsResponse
import com.example.unifyassignment.utill.NetworkingResult

interface DetailsRepository {
    suspend fun getDetails() : NetworkingResult<DetailsResponse>
}
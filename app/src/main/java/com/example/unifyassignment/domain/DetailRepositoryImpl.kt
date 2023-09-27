package com.example.unifyassignment.domain

import android.content.Context
import com.example.unifyassignment.data.response.DetailsResponse
import com.example.unifyassignment.utill.NetworkingResult
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DetailRepositoryImpl @Inject constructor(private val context: Context) : DetailsRepository {
    override suspend fun getDetails(): NetworkingResult<DetailsResponse> {
        return try {
            val data: DetailsResponse
            val inputStream = context.assets.open("details.json")
            val size: Int = withContext(Dispatchers.IO) {
                inputStream.available()
            }
            val buffer = ByteArray(size)
            withContext(Dispatchers.IO) {
                inputStream.read(buffer)
                inputStream.close()
            }
            val json = String(buffer, Charsets.UTF_8)
            val gson = Gson()
            data = gson.fromJson(json, DetailsResponse::class.java)
            NetworkingResult.Success(data)
        } catch (e: Exception) {
            e.printStackTrace()
            NetworkingResult.Error(e.localizedMessage.toString())
        }
    }
}
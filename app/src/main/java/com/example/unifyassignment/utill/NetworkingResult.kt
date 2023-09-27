package com.example.unifyassignment.utill

sealed class NetworkingResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : NetworkingResult<T>(data)
    class Error<T>(message: String, data: T? = null) : NetworkingResult<T>(data, message)
    class Loading<T> : NetworkingResult<T>()
}


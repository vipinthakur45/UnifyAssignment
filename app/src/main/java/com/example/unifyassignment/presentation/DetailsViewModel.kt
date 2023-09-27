package com.example.unifyassignment.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unifyassignment.data.response.DetailsResponse
import com.example.unifyassignment.domain.DetailsRepository
import com.example.unifyassignment.utill.NetworkingResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsRepository: DetailsRepository) :
    ViewModel() {
    private val _paymentDetailLiveData = MutableLiveData<DetailsResponse>()
    val paymentDetailLiveData: LiveData<DetailsResponse> = _paymentDetailLiveData


    fun getDetails(
        error: (String) -> Unit,
        loading: (Boolean) -> Unit
    ) =
        viewModelScope.launch {
            when (val data = detailsRepository.getDetails()) {
                is NetworkingResult.Error -> {
                    error.invoke(data.message ?: "Something Went Wrong")
                }

                is NetworkingResult.Loading -> {
                    loading.invoke(true)
                }

                is NetworkingResult.Success -> {
                    _paymentDetailLiveData.postValue(data.data)

                }
            }
        }
}
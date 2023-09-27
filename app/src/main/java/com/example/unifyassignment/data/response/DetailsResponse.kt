package com.example.unifyassignment.data.response


data class DetailsResponse(
    val payment_option: List<PaymentOptionItem?>? = null,
    val details: Details? = null,
    val pay_using: List<PayUsingItem?>? = null
)

data class Details(

	val valid_till: String? = null,
	val upto_amount: String? = null,
	val warning_description: String? = null,
	val frequency: String? = null
)

data class PaymentOptionItem(
	val image_url: String? = null
)

data class PayUsingItem(
	val account: String? = null
)

package com.sodiqjon.online_shop.model

data class BaseResponse<T>(
    val success:Boolean,
    val data: T,
    val messege: String,
    val error_code: Int
)

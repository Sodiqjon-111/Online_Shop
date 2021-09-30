package com.sodiqjon.online_shop.model.request

import java.io.Serializable

data class BasketModel(
    val product_id:Int,
    var count:Int
):Serializable

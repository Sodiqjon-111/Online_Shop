package com.sodiqjon.online_shop.model

import java.io.Serializable

data class TopProducts_model(
    val id:Int,
    val name:String,
    val price:String,
    val image:String,
    var cardCount:Int
):Serializable

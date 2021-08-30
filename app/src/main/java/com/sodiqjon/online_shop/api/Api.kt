package com.sodiqjon.online_shop.api

import com.sodiqjon.online_shop.model.BaseResponse
import com.sodiqjon.online_shop.model.Offer_model
import com.sodiqjon.online_shop.model.Categories_model
import com.sodiqjon.online_shop.model.TopProducts_model
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET ("get_offers")
    fun getOffers():Call<BaseResponse<List<Offer_model>>>

    @GET ("get_categories")
    fun getCategory():Call<BaseResponse<List<Categories_model>>>

    @GET ("get_top_products")
    fun getTopProducts():Call<BaseResponse<List<TopProducts_model>>>
}